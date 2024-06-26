JAVAC = javac

SOURCES = $(shell find . -name '*.java')

SOURCE_FILE = sources.txt

all: compile

$(SOURCE_FILE):
	echo $(SOURCES) > $(SOURCE_FILE)

compile: $(SOURCE_FILE)
	$(JAVAC) @$<

show:
	@test -f simulation.txt && cat -e simulation.txt || echo "File simulation.txt not found"

clean:
	find . -type f -name '*.class' -delete
	rm -f $(SOURCE_FILE)

fclean: clean

.PHONY: all compile clean


# java src/App scenario/scenario.txt