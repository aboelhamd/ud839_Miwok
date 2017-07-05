package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 02/07/2017.
 */

public class WordAdapter extends ArrayAdapter {

    private int colorId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorId) {
        super(context, 0, words);
        this.colorId = colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = (Word) getItem(position);

        // Background Color
        int color = ContextCompat.getColor(getContext(), colorId);

        // Find the TextView in the list_item.xml layout with the ID version_default
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version default from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());
        defaultTextView.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID version_miwok
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version miwok from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());
        miwokTextView.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
        iconView.setImageResource(currentWord.getImageId());

        if (currentWord.getImageId() == 0)
            iconView.setVisibility(View.GONE);


//        // Playing translation audio
//        View textContainer = listItemView.findViewById(R.id.text_container);
//        textContainer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer audio = MediaPlayer.create(getContext(), currentWord.getAudioId());
//                audio.start();
//            }
//        });


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

//        return super.getView(position, convertView, parent);
    }

}
