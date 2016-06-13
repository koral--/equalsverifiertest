package com.example.koral.equalsverifiertest;

import android.content.ContentUris;
import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MediaDescriptorTest {

	@Test
	public void testEquals() throws Exception {
		final Uri red = ContentUris.appendId(new Uri.Builder(), 1).build();
		final Uri black = ContentUris.appendId(new Uri.Builder(), 2).build();

		EqualsVerifier.forClass(MediaDescriptor.class)
				.withPrefabValues(Uri.class, red, black)
				.suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
				.verify();
	}
}