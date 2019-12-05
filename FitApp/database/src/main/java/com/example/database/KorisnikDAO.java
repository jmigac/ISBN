package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.core.entities.Korisnik;

@Dao
public interface KorisnikDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long[] unosKorisnika(Korisnik... korisnici);

    @Update public void azuriranjeKorisnika(Korisnik... korisnik);

    @Query("DELETE FROM korisnik")
    public void brisanjeKorisnika();

    @Query("SELECT * FROM korisnik WHERE google_id=:googleId")
    public Korisnik dohvatiKorisnikaPoGoogleId(String googleId);

    @Query("SELECT * FROM korisnik")
    public Korisnik dohvatiKorisnika();
}
