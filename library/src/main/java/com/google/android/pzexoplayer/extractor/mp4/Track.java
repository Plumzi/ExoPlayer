/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.pzexoplayer.extractor.mp4;

import com.google.android.pzexoplayer.C;
import com.google.android.pzexoplayer.MediaFormat;
import com.google.android.pzexoplayer.util.Util;

/**
 * Encapsulates information describing an MP4 track.
 */
public final class Track {

  /**
   * Type of a video track.
   */
  public static final int TYPE_VIDEO = Util.getIntegerCodeForString("vide");
  /**
   * Type of an audio track.
   */
  public static final int TYPE_AUDIO = Util.getIntegerCodeForString("soun");
  /**
   * Type of a text track.
   */
  public static final int TYPE_TEXT = Util.getIntegerCodeForString("text");
  /**
   * Type of a subtitle track.
   */
  public static final int TYPE_SUBTITLE = Util.getIntegerCodeForString("sbtl");

  /**
   * The track identifier.
   */
  public final int id;

  /**
   * One of {@link #TYPE_VIDEO}, {@link #TYPE_AUDIO}, {@link #TYPE_TEXT} and {@link #TYPE_SUBTITLE}.
   */
  public final int type;

  /**
   * The track timescale, defined as the number of time units that pass in one second.
   */
  public final long timescale;

  /**
   * The duration of the track in microseconds, or {@link C#UNKNOWN_TIME_US} if unknown.
   */
  public final long durationUs;

  /**
   * The format if {@link #type} is {@link #TYPE_VIDEO} or {@link #TYPE_AUDIO}. Null otherwise.
   */
  public final MediaFormat mediaFormat;

  /**
   * Track encryption boxes for the different track sample descriptions. Entries may be null.
   */
  public final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;

  /**
   * For H264 video tracks, the length in bytes of the NALUnitLength field in each sample. -1 for
   * other track types.
   */
  public final int nalUnitLengthFieldLength;

  public Track(int id, int type, long timescale, long durationUs, MediaFormat mediaFormat,
      TrackEncryptionBox[] sampleDescriptionEncryptionBoxes, int nalUnitLengthFieldLength) {
    this.id = id;
    this.type = type;
    this.timescale = timescale;
    this.durationUs = durationUs;
    this.mediaFormat = mediaFormat;
    this.sampleDescriptionEncryptionBoxes = sampleDescriptionEncryptionBoxes;
    this.nalUnitLengthFieldLength = nalUnitLengthFieldLength;
  }

}
