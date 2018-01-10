package com.example.a81947.read;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class bookContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,String bookTitle,String bookContent) {
        Intent intent = new Intent(context,bookContentActivity.class);
        intent.putExtra("book_title",bookTitle);
        intent.putExtra("book_content",bookContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_content);
        String bookTitle = getIntent().getStringExtra("book_title");
        String bookContent = getIntent().getStringExtra("book_content");
        bookContentFragment bookContentFragment = (com.example.a81947.read.bookContentFragment)getSupportFragmentManager().findFragmentById(R.id.book_content_fragment);
        bookContentFragment.refresh(bookTitle,bookContent); //refresh bookContent_Fragment界面
    }
}
