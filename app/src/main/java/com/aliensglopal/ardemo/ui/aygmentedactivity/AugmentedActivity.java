package com.aliensglopal.ardemo.ui.aygmentedactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.aliensglopal.ardemo.R;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class AugmentedActivity extends AppCompatActivity
{
    private static final String TAG = AugmentedActivity.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;

    ArFragment arFragment;
    ModelRenderable modelRenderable;

    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) ->
        {
            Toast.makeText(this, "fixed", Toast.LENGTH_SHORT).show();
            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse("ArcticFox_Posed.sfb"))
                   // .setSource(this, R.drawable.ic_launcher_background)
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor, modelRenderable))
                    .exceptionally(throwable ->
                    {
                        Toast toast = Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return null;
                    });
        });


    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable)
    {
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());

        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }
}

   /*     ModelRenderable.builder()
                .setSource(this, R.drawable.fox)
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.e(TAG, "Unable to load Renderable.", throwable);
                            return null;
                        });*/
/*

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) ->
        {
            Toast.makeText(this, "fixed", Toast.LENGTH_SHORT).show();
            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    // .setSource(this, Uri.parse("NOVELO_EARTH.sfb"))
                    .setSource(this, R.drawable.ic_launcher_background)
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor, modelRenderable))
                    .exceptionally(throwable ->
                    {
                        Toast toast = Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return null;
                    });
        });


      */
/*  ModelRenderable.builder()
                .setSource(this, R.drawable.fox)
                .build()
                .thenAccept(renderable -> lampPostRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.e(TAG, "Unable to load Renderable.", throwable);
                            return null;
                        });*//*


 */
/* if (!checkIsSupportedDeviceOrFinish(this))
        {
            return;
        }

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) ->
        {
            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                   // .setSource(this, Uri.parse("NOVELO_EARTH.sfb.sfb"))
                    .setSource(this, R.drawable.fox)
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor, modelRenderable))
                    .exceptionally(throwable ->
                    {
                        Toast toast = Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return null;
                    });
        });*//*

    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable)
    {
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());

        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }

    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity)
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }
}
*/
