URL  = https://pdc-tools.s3.amazonaws.com/pyjama/Pyjama.zip
PJ    = Pyjama
JAR   = $(PJ).jar

$(PJ):
	wget $(URL)
	unzip -o $(PJ).zip
	cp $(PJ)/*.jar $(JAR)
	rm -r -f Pyjama.zip Pyjama

clean:
	rm $(JAR)
	

