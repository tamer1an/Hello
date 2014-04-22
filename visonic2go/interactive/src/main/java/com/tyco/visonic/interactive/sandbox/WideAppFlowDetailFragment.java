package com.tyco.visonic.interactive.sandbox;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.tyco.visonic.interactive.R;
import com.tyco.visonic.interactive.dummy.DummyContent;

/**
 * A fragment representing a single WideAppFlow detail screen.
 * This fragment is either contained in a {@link WideAppFlowListActivity}
 * in two-pane mode (on tablets) or a {@link WideAppFlowDetailActivity}
 * on handsets.
 */
public class WideAppFlowDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WideAppFlowDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            if (getArguments().containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            }
        } catch (Exception ignored){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wideappflow_detail, container, false);

        // Show the dummy content as text in a TextView. android.R.id.content
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.wideappflow_detail)).setText(mItem.content);
        }

        return rootView;
    }
}
