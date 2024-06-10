JAVAC = javac

SOURCES = $(shell find . -name '*.java')

SOURCE_FILE = sources.txt

all: compile

$(SOURCE_FILE):
	echo $(SOURCES) > $(SOURCE_FILE)

compile: $(SOURCE_FILE)
	$(JAVAC) @$<

clean:
	find . -type f -name '*.class' -delete
	rm -f $(SOURCE_FILE)

.PHONY: all compile clean