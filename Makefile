JAVAC = javac

SOURCES = $(shell find . -name '*.java')

SOURCE_FILE = sources.txt

all: compile

$(SOURCE_FILE):
	echo $(SOURCES) > $(SOURCE_FILE)

compile: $(SOURCE_FILE)
	$(JAVAC) @$<

clean:
	rm -f *.class
	rm -f $(SOURCE_FILE)

.PHONY: all compile clean