package com.example.koral.equalsverifiertest;

import android.content.ContentUris;
import android.net.Uri;
import android.support.annotation.NonNull;

public final class MediaDescriptor {

	@NonNull
	private final MediaType mMediaType;
	final long mId;
	final Uri mUri;

	public MediaDescriptor(@NonNull MediaType mediaType, long id) {
		mMediaType = mediaType;
		mId = id;
		mUri = ContentUris.withAppendedId(new Uri.Builder().build(), id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MediaDescriptor that = (MediaDescriptor) o;

		return mId == that.mId;
	}

	@Override
	public int hashCode() {
		return (int) (mId ^ (mId >>> 32));
	}
}
