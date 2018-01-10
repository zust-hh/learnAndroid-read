package com.example.a81947.read;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 81947 on 2018/1/8.
 */

public class BookTitleFragment extends Fragment{
    private boolean isTwoPane;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_title_frag,container,false);
        RecyclerView bookTitleRecyclerView = (RecyclerView)view.findViewById(R.id.book_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bookTitleRecyclerView.setLayoutManager(layoutManager);
        BookAdapter adapter = new BookAdapter(getBook());
        bookTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<Content> getBook() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this.getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor =  db.rawQuery("select * from book", null);
        List<Content> bookList = new ArrayList<>();
        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String content =  cursor.getString(cursor.getColumnIndex("content"));

            Content book = new Content();
            book.setTitle(name);
            book.setContent(content);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.book_content_layout)!=null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
        private List<Content> mBookList;
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView bookTitleText;

            public ViewHolder(View view) {
                super(view);
                bookTitleText = (TextView)view.findViewById(R.id.book_title);
            }
        }

        public BookAdapter(List<Content> bookList) {
            mBookList = bookList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Content book = mBookList.get(holder.getAdapterPosition());
                    if(isTwoPane) {
                        bookContentFragment bookContentFragment = (bookContentFragment) getFragmentManager().findFragmentById(R.id.book_content_fragment);
                        bookContentFragment.refresh(book.getTitle(),book.getContent());
                    } else {
                        bookContentActivity.actionStart(getActivity(),book.getTitle(),book.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Content book = mBookList.get(position);
            holder.bookTitleText.setText(book.getTitle());
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }
}
