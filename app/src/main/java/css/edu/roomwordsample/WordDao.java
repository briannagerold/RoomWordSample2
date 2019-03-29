package css.edu.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    /**
     * inserts the given word into the database
     * @param word
     */
    @Insert
    void insert(Word word);

    /**
     * Deletes all the words from the table
     */
    @Query("DELETE FROM word_table")
    void deleteAll();

    /**
     * Selects all the words from the table.
     * @return
     */
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

}
