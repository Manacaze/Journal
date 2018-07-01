package com.example.android.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.android.model.Journal;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class JournalDao_Impl implements JournalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfJournal;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfJournal;

  public JournalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJournal = new EntityInsertionAdapter<Journal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `journal`(`id`,`title`,`detail`,`dateCreated`,`dateModifyed`,`email`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Journal value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDetail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetail());
        }
        if (value.getDateCreated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateCreated());
        }
        if (value.getDateModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateModified());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
      }
    };
    this.__deletionAdapterOfJournal = new EntityDeletionOrUpdateAdapter<Journal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `journal` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Journal value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertAll(Journal... journals) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfJournal.insert(journals);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Journal journal) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfJournal.handle(journal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Journal> getAll() {
    final String _sql = "SELECT * FROM journal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfDetail = _cursor.getColumnIndexOrThrow("detail");
      final int _cursorIndexOfDateCreated = _cursor.getColumnIndexOrThrow("dateCreated");
      final int _cursorIndexOfDateModified = _cursor.getColumnIndexOrThrow("dateModifyed");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final List<Journal> _result = new ArrayList<Journal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Journal _item;
        _item = new Journal();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpDetail;
        _tmpDetail = _cursor.getString(_cursorIndexOfDetail);
        _item.setDetail(_tmpDetail);
        final String _tmpDateCreated;
        _tmpDateCreated = _cursor.getString(_cursorIndexOfDateCreated);
        _item.setDateCreated(_tmpDateCreated);
        final String _tmpDateModified;
        _tmpDateModified = _cursor.getString(_cursorIndexOfDateModified);
        _item.setDateModified(_tmpDateModified);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Journal> loadAllByEmail(String email) {
    final String _sql = "SELECT * FROM journal WHERE email LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfDetail = _cursor.getColumnIndexOrThrow("detail");
      final int _cursorIndexOfDateCreated = _cursor.getColumnIndexOrThrow("dateCreated");
      final int _cursorIndexOfDateModified = _cursor.getColumnIndexOrThrow("dateModifyed");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final List<Journal> _result = new ArrayList<Journal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Journal _item;
        _item = new Journal();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpDetail;
        _tmpDetail = _cursor.getString(_cursorIndexOfDetail);
        _item.setDetail(_tmpDetail);
        final String _tmpDateCreated;
        _tmpDateCreated = _cursor.getString(_cursorIndexOfDateCreated);
        _item.setDateCreated(_tmpDateCreated);
        final String _tmpDateModified;
        _tmpDateModified = _cursor.getString(_cursorIndexOfDateModified);
        _item.setDateModified(_tmpDateModified);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Journal findById(int id) {
    final String _sql = "SELECT * FROM journal WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfDetail = _cursor.getColumnIndexOrThrow("detail");
      final int _cursorIndexOfDateCreated = _cursor.getColumnIndexOrThrow("dateCreated");
      final int _cursorIndexOfDateModified = _cursor.getColumnIndexOrThrow("dateModifyed");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final Journal _result;
      if(_cursor.moveToFirst()) {
        _result = new Journal();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _result.setTitle(_tmpTitle);
        final String _tmpDetail;
        _tmpDetail = _cursor.getString(_cursorIndexOfDetail);
        _result.setDetail(_tmpDetail);
        final String _tmpDateCreated;
        _tmpDateCreated = _cursor.getString(_cursorIndexOfDateCreated);
        _result.setDateCreated(_tmpDateCreated);
        final String _tmpDateModified;
        _tmpDateModified = _cursor.getString(_cursorIndexOfDateModified);
        _result.setDateModified(_tmpDateModified);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
