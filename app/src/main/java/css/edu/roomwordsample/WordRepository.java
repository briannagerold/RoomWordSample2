package css.edu.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    /**
     * WordRepository constructor
     * @param application
     */
    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAllWords();
    }

    /**
     * returns all the words
     * @return
     */
    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    /**
     * inserts  a new word asynchronous
     * @param word
     */
    public void insert (Word word) {
        new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask  extends AsyncTask<Word, Void, Void> {
        private WordDao asyncTaskDao;

        /**
         * constructor for inner class insertAsyncTask
         * @param dao
         */
        insertAsyncTask (WordDao dao){
            asyncTaskDao = dao;
        }

        /**
         * insert the word in the background
         * @param params
         * @return
         */
        @Override
        protected Void doInBackground(final Word... params){
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
