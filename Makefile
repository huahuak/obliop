# // ------------------ java ------------------ //
CLASSES = ./target/classes

EMPTY :=
SPACE := $(EMPTY) $(EMPTY)
DEPENDENCIDES = $(wildcard ./target/dependency/*.jar)
DEPENDENCIDES_STR = $(subst $(SPACE),:,$(DEPENDENCIDES))

MAIN_CLASS = org.kaihua.obliop.Main

# // ------------------ rust ------------------ //

CARGO_TOML = ./obliclient/Cargo.toml

# // ------------------ shell ------------------ //
SHELL = /usr/bin/zsh
COLOR=\033[0;33m
NC=\033[0m # No Color

# // ------------------ optee env ------------------ //
OPTEE_RUST = /home/huahua/Projects/rust_optee/optee_rust
OPTEE_CLIENT = ${OPTEE_RUST}/examples/hello_world-rs/obliop/obliclient
OUT_PATH = ${OPTEE_RUST}/out
JAVA_OUT_PATH = ${OUT_PATH}/java
RES_OUT_PATH = ${OUT_PATH}/res

# // ------------------ optee ------------------ //
# mkdir lkh && mount -t 9p -o trans=virtio host lkh && cd lkh && chmod +x ./optee.sh

aarch:	dep
	@mvn package
	@source ${OPTEE_RUST}/environment
	@make -C ${OPTEE_CLIENT} host

	@if [ ! -d "${OUT_PATH}" ]; then\
		mkdir ${OUT_PATH};\
	fi

	@if [ ! -d "${JAVA_OUT_PATH}" ]; then\
		mkdir ${JAVA_OUT_PATH};\
	fi
	@cp -f ${OPTEE_CLIENT}/target/aarch64-unknown-linux-gnu/debug/libobliclient.so ${JAVA_OUT_PATH}
	@cp -f ./target/dependency/* ${JAVA_OUT_PATH}
	@cp ./target/obliop-3.3.1.jar ${JAVA_OUT_PATH}

	@if [ ! -d "${RES_OUT_PATH}" ]; then\
		mkdir ${RES_OUT_PATH};\
		cp -r ./res/* ${RES_OUT_PATH};\
	fi
	@cp -f ./optee.sh ${OUT_PATH}


local:
	@mvn compile
	@cargo build --manifest-path $(CARGO_TOML) 
	@echo "${COLOR}\n// ------------------ BEGIN ------------------ //\n${NC}"
	@java -cp $(DEPENDENCIDES_STR):$(CLASSES) $(MAIN_CLASS)

dep:
	mvn dependency:copy-dependencies

clean: 
	mvn clean
	rm -rf /home/huahua/Projects/rust_optee/optee_rust/out