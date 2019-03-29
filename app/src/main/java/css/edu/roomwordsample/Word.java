package css.edu.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    /**
     * The constructor for a word object
     * @param word
     */
    public Word(@NonNull String word){
        this.word = word;
    }

    /**
     * Gets the word from the object
     * @return
     */
    public String getWord(){
        return word;
    }
}
