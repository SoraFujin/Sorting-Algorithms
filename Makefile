SRC_DIR = src/main/java
OUT_DIR = out
SOURCES = $(wildcard $(SRC_DIR)/com/sort/*/*.java)

all:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) -sourcepath $(SRC_DIR) $(SOURCES)

run: all
	@if [ -z "$(CLASS)" ]; then 		echo "Usage: make run CLASS=<class_name>"; 		exit 1; 	fi
	java -cp $(OUT_DIR) $(CLASS)

clean:
	rm -rf $(OUT_DIR)
