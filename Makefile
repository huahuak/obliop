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
SPARK = /home/huahua/Projects/spark-3.3.1
OPTEE_RUST = /home/huahua/Projects/rust_optee/optee_rust
OPTEE_CLIENT = ${OPTEE_RUST}/examples/hello_world-rs/obliop/obliclient
OPTEE_SPARK = ${OPTEE_RUST}/examples/hello_world-rs/obliop
OPTEE_CJNI = ${OPTEE_SPARK}/src/main/java/org/kaihua/obliop/interfaces/cjni
OUT_PATH = ${OPTEE_RUST}/out
JAVA_OUT_PATH = ${OUT_PATH}/java
SPARK_OUT_PATH = ${OUT_PATH}/spark
RES_OUT_PATH = ${OUT_PATH}/res

# // ------------------ optee ------------------ //
# mkdir lkh && mount -t 9p -o trans=virtio host lkh && cd lkh && chmod +x ./optee.sh && chmod +x ./spark/run.sh

aarch:	dep
# compile java and rust code
	@mvn package
	@source ${OPTEE_RUST}/environment
	@make -C ${OPTEE_CLIENT} host
# mkdir
	@if [ ! -d "${OUT_PATH}" ]; then\
		mkdir ${OUT_PATH};\
	fi

	@if [ ! -d "${JAVA_OUT_PATH}" ]; then\
		mkdir ${JAVA_OUT_PATH};\
	fi
	
	@if [ ! -d "${SPARK_OUT_PATH}" ]; then\
		mkdir ${SPARK_OUT_PATH};\
	fi
# c-JNI make
	@make -C ${OPTEE_CJNI}
	@cp ${OPTEE_CJNI}/libcjni.so ${JAVA_OUT_PATH}
# copy rust shared library
	@cp -f ${OPTEE_CLIENT}/target/aarch64-unknown-linux-gnu/debug/libobliclient.so ${JAVA_OUT_PATH}
# copy spark to rust interface dependency jars
	@cp -f ./target/dependency/* ${JAVA_OUT_PATH}
	@cp ./target/obliop-3.3.1.jar ${JAVA_OUT_PATH}
# copy spark jars
	cp -rf ${SPARK}/dist ${SPARK_OUT_PATH}
	cp -f ${SPARK}/run.sh ${SPARK_OUT_PATH}



	@if [ ! -d "${RES_OUT_PATH}" ]; then\
		mkdir ${RES_OUT_PATH};\
		cp -r ./res/* ${RES_OUT_PATH};\
	fi
# copy start shell script
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