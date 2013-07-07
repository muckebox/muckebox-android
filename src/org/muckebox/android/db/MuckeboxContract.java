package org.muckebox.android.db;

import android.provider.BaseColumns;

public final class MuckeboxContract {
	public MuckeboxContract() { }
	
	public static final String AS = " AS ";
	public static final String ASC = " COLLATE LOCALIZED ASC";
	
	public static abstract class ArtistEntry implements BaseColumns {
		public static final String TABLE_NAME = "artists";
		
		public static final String SHORT_ID = _ID;
		public static final String SHORT_NAME = "name";
		
		public static final String FULL_ID		= TABLE_NAME + "." + SHORT_ID;
		public static final String FULL_NAME	= TABLE_NAME + "." + SHORT_NAME;
		
		public static final String ALIAS_ID		= TABLE_NAME + "_" + SHORT_ID;
		public static final String ALIAS_NAME	= TABLE_NAME + "_" + SHORT_NAME;
		
    	public static final String[] PROJECTION = {
    		FULL_ID,
    		FULL_NAME + AS + ALIAS_NAME
    	};
    	
    	public final static String SORT_ORDER = ALIAS_NAME + ASC;
	}
	
	public static abstract class AlbumEntry implements BaseColumns {
		public static final String TABLE_NAME = "albums";
		
		public static final String SHORT_ID			= _ID;
		public static final String SHORT_COUNT		= _COUNT;
		public static final String SHORT_ARTIST_ID	= "artist_id";
		public static final String SHORT_TITLE 		= "title";
		
		public static final String FULL_ID 			= TABLE_NAME + "." + SHORT_ID;
		public static final String FULL_ARTIST_ID 	= TABLE_NAME + "." + SHORT_ARTIST_ID;
		public static final String FULL_TITLE		= TABLE_NAME + "." + SHORT_TITLE;

		public static final String ALIAS_ID 		= TABLE_NAME + "_" + SHORT_ID;
		public static final String ALIAS_COUNT		= TABLE_NAME + "_" + SHORT_COUNT;
		public static final String ALIAS_ARTIST_ID 	= TABLE_NAME + "_" + SHORT_ARTIST_ID;
		public static final String ALIAS_TITLE		= TABLE_NAME + "_" + SHORT_TITLE;
		
		public static final String[] PROJECTION = {
			FULL_ID,
			FULL_ARTIST_ID + AS + ALIAS_ARTIST_ID,
			FULL_TITLE + AS + ALIAS_TITLE
		};
		
		public static final String SORT_ORDER = ALIAS_TITLE + ASC;
	}
	
	public static abstract class TrackEntry implements BaseColumns {
		public static final String TABLE_NAME	= "tracks";
		
		public static final String SHORT_ID				= _ID;

		public static final String SHORT_ALBUM_ID		= "album_id";
		public static final String SHORT_ARTIST_ID		= "artist_id";
		public static final String SHORT_TITLE			= "title";
		
		public static final String SHORT_TRACKNUMBER	= "tracknumber";
		public static final String SHORT_DISCNUMBER		= "discnumber";
		
		public static final String SHORT_LABEL			= "label";
		public static final String SHORT_CATALOGNUMBER	= "catalognumber";
		
		public static final String SHORT_LENGTH			= "length";
		public static final String SHORT_DISPLAY_ARTIST	= "display_artist";
		public static final String SHORT_DATE			= "date";
		
		public static final String FULL_ID				= TABLE_NAME + "." + SHORT_ID;
		public static final String FULL_ALBUM_ID		= TABLE_NAME + "." + SHORT_ALBUM_ID;
		public static final String FULL_ARTIST_ID		= TABLE_NAME + "." + SHORT_ARTIST_ID;
		public static final String FULL_TITLE			= TABLE_NAME + "." + SHORT_TITLE;
		public static final String FULL_TRACKNUMBER		= TABLE_NAME + "." + SHORT_TRACKNUMBER;
		public static final String FULL_DISCNUMBER		= TABLE_NAME + "." + SHORT_DISCNUMBER;
		public static final String FULL_LABEL			= TABLE_NAME + "." + SHORT_LABEL;
		public static final String FULL_CATALOGNUMBER	= TABLE_NAME + "." + SHORT_CATALOGNUMBER;
		public static final String FULL_LENGTH			= TABLE_NAME + "." + SHORT_LENGTH;
		public static final String FULL_DISPLAY_ARTIST	= TABLE_NAME + "." + SHORT_DISPLAY_ARTIST;
		public static final String FULL_DATE			= TABLE_NAME + "." + SHORT_DATE;		
		
		public static final String ALIAS_ID				= TABLE_NAME + "_" + SHORT_ID;
		public static final String ALIAS_ALBUM_ID		= TABLE_NAME + "_" + SHORT_ALBUM_ID;
		public static final String ALIAS_ARTIST_ID		= TABLE_NAME + "_" + SHORT_ARTIST_ID;
		public static final String ALIAS_TITLE			= TABLE_NAME + "_" + SHORT_TITLE;
		public static final String ALIAS_TRACKNUMBER	= TABLE_NAME + "_" + SHORT_TRACKNUMBER;
		public static final String ALIAS_DISCNUMBER		= TABLE_NAME + "_" + SHORT_DISCNUMBER;
		public static final String ALIAS_LABEL			= TABLE_NAME + "_" + SHORT_LABEL;
		public static final String ALIAS_CATALOGNUMBER	= TABLE_NAME + "_" + SHORT_CATALOGNUMBER;
		public static final String ALIAS_LENGTH			= TABLE_NAME + "_" + SHORT_LENGTH;
		public static final String ALIAS_DISPLAY_ARTIST	= TABLE_NAME + "_" + SHORT_DISPLAY_ARTIST;
		public static final String ALIAS_DATE			= TABLE_NAME + "_" + SHORT_DATE;
		
		public static final String[] PROJECTION = {
			FULL_ID,
			FULL_ALBUM_ID + AS + ALIAS_ALBUM_ID,
			FULL_ARTIST_ID + AS + ALIAS_ARTIST_ID,
			FULL_TITLE + AS + ALIAS_TITLE,
			
			FULL_TRACKNUMBER + AS + ALIAS_TRACKNUMBER,
			FULL_DISCNUMBER + AS + ALIAS_DISCNUMBER,
			
			FULL_LABEL + AS + ALIAS_LABEL,
			FULL_CATALOGNUMBER + AS + ALIAS_CATALOGNUMBER,
			
			FULL_LENGTH + AS + ALIAS_LENGTH,
			FULL_DISPLAY_ARTIST + AS + ALIAS_DISPLAY_ARTIST,
			FULL_DATE + AS + ALIAS_DATE
		};
		
		public static final String SORT_ORDER =
				"(" + FULL_DISCNUMBER + " * 1000 + " +
				FULL_TRACKNUMBER + ") ASC ";
	}
	
	public static abstract class DownloadEntry implements BaseColumns {
		public static final String TABLE_NAME = "downloads";
		
		public static final String SHORT_ID						= _ID;
		
		public static final String SHORT_TIMESTAMP				= "timestamp";
		public static final String SHORT_TRACK_ID				= "track_id";
		
		public static final String SHORT_TRANSCODE				= "transcode";
		public static final String SHORT_TRANSCODING_TYPE		= "transcoding_type";
		public static final String SHORT_TRANSCODING_QUALITY	= "transcoding_quality";
		
		public static final String SHORT_PIN_RESULT				= "pin_result";
		
		// this is effectively an enum
		public static final String SHORT_STATUS					= "status";
		public static final String STATUS_VALUE_QUEUED			= "status_queued";
		public static final String STATUS_VALUE_DOWNLOADING		= "status_downloading";
		
		public static final String SHORT_BYTES_DOWNLOADED		= "bytes_downloaded";
		
		public static final String FULL_ID					= TABLE_NAME + "." + SHORT_ID;
		
		public static final String FULL_TIMESTAMP			= TABLE_NAME + "." + SHORT_TIMESTAMP;
		public static final String FULL_TRACK_ID			= TABLE_NAME + "." + SHORT_TRACK_ID;
		
		public static final String FULL_TRANSCODE			= TABLE_NAME + "." + SHORT_TRANSCODE;
		public static final String FULL_TRANSCODING_TYPE	= TABLE_NAME + "." + SHORT_TRANSCODING_TYPE;
		public static final String FULL_TRANSCODING_QUALITY	= TABLE_NAME + "." + SHORT_TRANSCODING_QUALITY;

		public static final String FULL_PIN_RESULT			= TABLE_NAME + "." + SHORT_PIN_RESULT;
		
		public static final String FULL_STATUS				= TABLE_NAME + "." + SHORT_STATUS;
		
		public static final String FULL_BYTES_DOWNLOADED	= TABLE_NAME + "." + SHORT_BYTES_DOWNLOADED;
		
		public static final String ALIAS_ID						= TABLE_NAME + "_" + SHORT_ID;
		
		public static final String ALIAS_TIMESTAMP				= TABLE_NAME + "_" + SHORT_TIMESTAMP;
		public static final String ALIAS_TRACK_ID				= TABLE_NAME + "_" + SHORT_TRACK_ID;
		
		public static final String ALIAS_TRANSCODE				= TABLE_NAME + "_" + SHORT_TRANSCODE;
		public static final String ALIAS_TRANSCODING_TYPE		= TABLE_NAME + "_" + SHORT_TRANSCODING_TYPE;
		public static final String ALIAS_TRANSCODING_QUALITY	= TABLE_NAME + "_" + SHORT_TRANSCODING_QUALITY;

		public static final String ALIAS_PIN_RESULT				= TABLE_NAME + "_" + SHORT_PIN_RESULT;
		
		public static final String ALIAS_STATUS					= TABLE_NAME + "_" + SHORT_STATUS;
		public static final String ALIAS_BYTES_DOWNLOADED		= TABLE_NAME + "_" + SHORT_BYTES_DOWNLOADED;
		
		public static final String[] PROJECTION = {
			FULL_ID,
			
			FULL_TIMESTAMP + AS + ALIAS_TIMESTAMP,
			FULL_TRACK_ID + AS + ALIAS_TRACK_ID,
			
			FULL_TRANSCODE + AS + ALIAS_TRANSCODE,
			FULL_TRANSCODING_TYPE + AS + ALIAS_TRANSCODING_TYPE,
			FULL_TRANSCODING_QUALITY + AS + ALIAS_TRANSCODING_QUALITY,

			FULL_PIN_RESULT + AS + ALIAS_PIN_RESULT,

			FULL_STATUS + AS + ALIAS_STATUS,
			FULL_BYTES_DOWNLOADED + AS + ALIAS_BYTES_DOWNLOADED
		};
		
		public static final String SORT_ORDER = FULL_TIMESTAMP + " ASC";
	}
	
	public static abstract class CacheEntry implements BaseColumns {
		public static final String TABLE_NAME = "cache";
		
		public static final String SHORT_ID = _ID;
		
		public static final String SHORT_TRACK_ID				= "track_id";
		
		public static final String SHORT_FILENAME				= "filename";
		public static final String SHORT_MIME_TYPE				= "mime_type";
		public static final String SHORT_SIZE					= "size";
		public static final String SHORT_TIMESTAMP				= "timestamp";
		
		public static final String SHORT_TRANSCODED				= "transcoded";
		public static final String SHORT_TRANCODING_TYPE		= "transcoding_type";
		public static final String SHORT_TRANSCODING_QUALITY	= "transcoding_quality";
		
		public static final String SHORT_PINNED					= "pinned";
		
		public static final String FULL_ID					= TABLE_NAME + "." + SHORT_ID;

		public static final String FULL_TRACK_ID			= TABLE_NAME + "." + SHORT_TRACK_ID;

		public static final String FULL_FILENAME			= TABLE_NAME + "." + SHORT_FILENAME;
		public static final String FULL_MIME_TYPE			= TABLE_NAME + "." + SHORT_MIME_TYPE;
		public static final String FULL_SIZE				= TABLE_NAME + "." + SHORT_SIZE;
		public static final String FULL_TIMESTAMP			= TABLE_NAME + "." + SHORT_TIMESTAMP;

		public static final String FULL_TRANSCODED			= TABLE_NAME + "." + SHORT_TRANSCODED;
		public static final String FULL_TRANSCODING_TYPE	= TABLE_NAME + "." + SHORT_TRANCODING_TYPE;
		public static final String FULL_TRANSCODING_QUALITY	= TABLE_NAME + "." + SHORT_TRANSCODING_QUALITY;

		public static final String FULL_PINNED				= TABLE_NAME + "." + SHORT_PINNED;

		public static final String ALIAS_ID						= TABLE_NAME + "_" + SHORT_ID;

		public static final String ALIAS_TRACK_ID				= TABLE_NAME + "_" + SHORT_TRACK_ID;

		public static final String ALIAS_FILENAME				= TABLE_NAME + "_" + SHORT_FILENAME;
		public static final String ALIAS_MIME_TYPE				= TABLE_NAME + "_" + SHORT_MIME_TYPE;
		public static final String ALIAS_SIZE					= TABLE_NAME + "_" + SHORT_SIZE;
		public static final String ALIAS_TIMESTAMP				= TABLE_NAME + "_" + SHORT_TIMESTAMP;

		public static final String ALIAS_TRANSCODED				= TABLE_NAME + "_" + SHORT_TRANSCODED;
		public static final String ALIAS_TRANSCODING_TYPE		= TABLE_NAME + "_" + SHORT_TRANCODING_TYPE;
		public static final String ALIAS_TRANSCODING_QUALITY	= TABLE_NAME + "_" + SHORT_TRANSCODING_QUALITY;

		public static final String ALIAS_PINNED					= TABLE_NAME + "_" + SHORT_PINNED;
		
		public static final String[] PROJECTION =
			{
				FULL_ID,
				
				FULL_TRACK_ID + AS + ALIAS_TRACK_ID,
				
				FULL_FILENAME + AS + ALIAS_FILENAME,
				FULL_MIME_TYPE + AS + ALIAS_MIME_TYPE,
				FULL_SIZE + AS + ALIAS_SIZE,
				FULL_TIMESTAMP + AS + ALIAS_TIMESTAMP,
				
				FULL_TRANSCODED + AS + ALIAS_TRANSCODED,
				FULL_TRANSCODING_TYPE + AS + ALIAS_TRANSCODING_TYPE,
				FULL_TRANSCODING_QUALITY + AS + ALIAS_TRANSCODING_QUALITY,
				
				FULL_PINNED + AS + ALIAS_PINNED
			};
		
		// we probably don't need to sort those
		public static final String SORT_ORDER = null;
}
	
	public static abstract class AlbumArtistJoin implements BaseColumns {
		public static final String TABLE_NAME = AlbumEntry.TABLE_NAME + " LEFT OUTER JOIN " +
				ArtistEntry.TABLE_NAME + " ON (" + AlbumEntry.FULL_ARTIST_ID + " = " +
				ArtistEntry.FULL_ID + ")";
		
		public static final String[] PROJECTION = {
			AlbumEntry.FULL_ID,
			AlbumEntry.FULL_TITLE + AS + AlbumEntry.ALIAS_TITLE,
			
			ArtistEntry.FULL_ID + AS + ArtistEntry.ALIAS_ID,
			ArtistEntry.FULL_NAME + AS + ArtistEntry.ALIAS_NAME
		};
		
		public static final String SORT_ORDER = AlbumEntry.SORT_ORDER;
	}
	
	public static abstract class ArtistAlbumJoin implements BaseColumns {
		public static final String TABLE_NAME = ArtistEntry.TABLE_NAME + " JOIN " +
				AlbumEntry.TABLE_NAME + " ON (" + ArtistEntry.FULL_ID + " = " +
				AlbumEntry.FULL_ARTIST_ID + ")";
		
		public static final String[] PROJECTION = {
			ArtistEntry.FULL_ID,
			ArtistEntry.FULL_NAME + AS + ArtistEntry.ALIAS_NAME,
			"GROUP_CONCAT(" + AlbumEntry.FULL_TITLE + ", ', ') " + AS + AlbumEntry.ALIAS_TITLE
		};
		
		public static final String SORT_ORDER = ArtistEntry.SORT_ORDER;
		public static final String GROUP_BY = ArtistEntry.FULL_ID;
	}
}
