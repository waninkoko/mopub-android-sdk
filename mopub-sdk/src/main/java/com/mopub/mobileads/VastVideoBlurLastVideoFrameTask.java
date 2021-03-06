package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;
import com.mopub.mobileads.resource.DrawableConstants;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {
    @NonNull private final MediaMetadataRetriever mMediaMetadataRetriever;
    @NonNull private final ImageView mBlurredLastVideoFrameImageView;
    private int mVideoDuration;
    @Nullable private Bitmap mLastVideoFrame;
    @Nullable private Bitmap mBlurredLastVideoFrame;

    public VastVideoBlurLastVideoFrameTask(
            @NonNull final MediaMetadataRetriever mediaMetadataRetriever,
            @NonNull final ImageView blurredLastVideoFrameImageView, int videoDuration) {
        mMediaMetadataRetriever = mediaMetadataRetriever;
        mBlurredLastVideoFrameImageView = blurredLastVideoFrameImageView;
        mVideoDuration = videoDuration;
    }

    @Override
    protected Boolean doInBackground(String... videoPaths) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
            if (videoPaths == null || videoPaths.length == 0 || videoPaths[0] == null) {
                return false;
            }

            try {
                final String videoPath = videoPaths[0];

                mMediaMetadataRetriever.setDataSource(videoPath);

                mLastVideoFrame = mMediaMetadataRetriever.getFrameAtTime(
                        mVideoDuration * 1000, MediaMetadataRetriever.OPTION_CLOSEST);

                if (mLastVideoFrame == null) {
                    return false;
                }

                mBlurredLastVideoFrame = ImageUtils.applyFastGaussianBlurToBitmap(
                        mLastVideoFrame, 4);

                return true;
            } catch (Exception e) {
                MoPubLog.d("Failed to blur last video frame", e);
                return false;
            }
        }

        return false;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        if (isCancelled()) {
            onCancelled();
            return;
        }

        if (success != null && success) {
            mBlurredLastVideoFrameImageView.setImageBitmap(mBlurredLastVideoFrame);
            ImageUtils.setImageViewAlpha(mBlurredLastVideoFrameImageView,
                    DrawableConstants.BlurredLastVideoFrame.ALPHA);
        }
    }

    @Override
    protected void onCancelled() {
        MoPubLog.d("VastVideoBlurLastVideoFrameTask was cancelled.");
    }

    // for testing
    @Deprecated
    @VisibleForTesting
    Bitmap getBlurredLastVideoFrame() {
        return mBlurredLastVideoFrame;
    }
}
