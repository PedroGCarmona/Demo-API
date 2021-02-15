INSERT INTO artist(id_artist,name_artist, album_qt) VALUES (1,'John Frusciante',11);
INSERT INTO artist(id_artist,name_artist, album_qt) VALUES (2,'Pink Floyd',15);
INSERT INTO artist(id_artist,name_artist, album_qt) VALUES (3,'Radiohead',9);

INSERT INTO album(id_album,name_album, song_qt, release_dt, fk_artist) VALUES(1,'Curtains', 11, {ts '2004-02-01 00:00:00'} , 1);
INSERT INTO album(id_album,name_album, song_qt, release_dt, fk_artist) VALUES(2,'The Wall', 26, {ts '1979-11-30 00:00:00'}, 2);
INSERT INTO album(id_album,name_album, song_qt, release_dt, fk_artist) VALUES(3,'OK Computer', 12, {ts '1997-05-21 00:00:00'}, 3);

INSERT INTO song(id_song,name_song, length_sec, fk_album) VALUES(1,'Anne', 216, 1);
INSERT INTO song(id_song,name_song, length_sec, fk_album) VALUES(2,'Hey You', 281, 2);
INSERT INTO song(id_song,name_song, length_sec, fk_album) VALUES(3,'No Surprises', 230, 3);