# // ------------------ java ------------------ //
CLASSES = /Users/huahua/IdeaProjects/spark-3.3.1/obliop/target/classes

EMPTY :=
SPACE := $(EMPTY) $(EMPTY)
DEPENDENCIDES = $(wildcard ./target/dependency/*.jar)
DEPENDENCIDES_PATH = $(subst $(SPACE),:,$(DEPENDENCIDES))

MAIN_CLASS = org.kaihua.obliop.Main

# // ------------------ rust ------------------ //

CARGO_TOML = /Users/huahua/IdeaProjects/obliclient/Cargo.toml

# // ------------------ shell ------------------ //
COLOR=\033[0;33m
NC=\033[0m # No Color

all:
	@mvn compile > /dev/null
	@cargo build --manifest-path $(CARGO_TOML) > /dev/null
	@echo "${COLOR}\n// ------------------ BEGIN ------------------ //\n${NC}"
	@java -cp $(DEPENDENCIDES_PATH):$(CLASSES) $(MAIN_CLASS)

dep:
	mvn dependency:copy-dependencies

clean: 
	mvn clean