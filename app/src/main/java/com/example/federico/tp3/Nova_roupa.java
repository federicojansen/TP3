package com.example.federico.tp3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Nova_roupa extends Activity {

    ImageView imgView;
    Button button_load, button_fim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_roupa);

        imgView = (ImageView) findViewById(R.id.imageView2);
        button_load = (Button) findViewById(R.id.buttonLoadPicture);
        button_fim = (Button) findViewById(R.id.button);

        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        button_fim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(Nova_roupa.this, Nova_roupa2.class);
                startActivity(it);
            }
        });
    }


    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds options to the action bar if it is present.
    //  getMenuInflater().inflate(R.menu.main, menu);
    //  return true;
    //}

    private void selectImage() {

        final CharSequence[] options = {"Tirar Foto", "Escolher da galeria", "Cancelar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Nova_roupa.this);
        builder.setTitle("Adicionar Foto");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Tirar Foto")) {

                    if (checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                1);
                    } else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                        startActivityForResult(intent, 1);
                    }
                } else if (options[item].equals("Escolher da galeria")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancelar")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgView.setImageBitmap(photo);

                /*
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);

                    imgView.setImageBitmap(bitmap);

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/
            } else if (requestCode == 2) {


                Uri selectedImage = data.getData();
            try{
               InputStream image_stream = getContentResolver().openInputStream(selectedImage);
                Bitmap bitmap= BitmapFactory.decodeStream(image_stream );
                imgView.setImageBitmap(bitmap);
            }catch(IOException e){
                e.printStackTrace();
            }
                // InputStream image_stream = getContentResolver().openInputStream(selectedImage);
                //Bitmap bitmap= BitmapFactory.decodeStream(image_stream );
                //imgView.setImageBitmap(bitmap);
                //Bitmap photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                //imgView.setImageBitmap(photo);
                /*
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gallery......******************.........", picturePath+"");
                imgView.setImageBitmap(thumbnail);*/

            }
        }
    }
}
/*
    @Override
    @SuppressLint("NewApi")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);
            startCropImageActivity(imageUri);
            CropImage.activity(imageUri)
                    .setGuidelines(imgView.Guidelines.ON)
                    .start(this);
        }
    }*/