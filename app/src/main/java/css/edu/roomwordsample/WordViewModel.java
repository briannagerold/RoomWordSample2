package css.edu.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.AndroidException;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository repo;
    private LiveData<List<Word>> allWords;

    /**
     * WordViewModel constructor
     * passes the application to the super class
     * creates a new repository and gets all the words
     * @param application
     */
    public WordViewModel(Application application){
        super(application);
        repo = new WordRepository(application);
        allWords = repo.getAllWords();
    }

    /**
     * Returns all the words
     * @return
     */
    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    /**
     * Calls the repo's insert method
     * and passes the word that will be inserted
     * @param word
     */
    public void insert(Word word){
        repo.insert(word);
    }


}
