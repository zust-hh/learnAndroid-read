package com.example.a81947.read;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 81947 on 2018/1/8.
 */

public class bookContentFragment extends Fragment{
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_frag,container,false);
        return view;
    }
    public void refresh(String bookTitle,String bookContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView bookTitleText = (TextView)view.findViewById(R.id.book_title);
        TextView bookContentText = (TextView)view.findViewById(R.id.book_content);
        bookTitleText.setText(bookTitle);
        bookContentText.setText(bookContent);
    }
}
