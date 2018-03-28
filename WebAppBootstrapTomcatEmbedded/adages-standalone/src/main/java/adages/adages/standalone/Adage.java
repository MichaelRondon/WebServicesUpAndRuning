package adages.adages.standalone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@XmlRootElement(name = "adage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"words", "wordCount"})
public class Adage {

    private String words;
    private int wordCount;

    @Override
    public String toString() {
        return words + " -- " + wordCount + " words";
    }

    public void setWords(String words) {
        this.words = words;
        this.wordCount = words.trim().split("\\s+").length;
    }

    public String getWords() {
        return this.words;
    }

    public void setWordCount(int wordCount) {
    }

    public int getWordCount() {
        return this.wordCount;
    }
}
