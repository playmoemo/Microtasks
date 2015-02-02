package no.ife.hrp.microtasks;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by oyvind on 21.01.2015.
 */
public class QuestionPageFragment extends Fragment {

    public static final String ARG_PAGE = "page";
    private int mPageNumber;

    /**
    * Factory method for the fragment class.
    */
    public static QuestionPageFragment create(int pageNumber) {
        QuestionPageFragment fragment = new QuestionPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);

        return fragment;
    }

    public QuestionPageFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // retrieve text from array and index elements with currentPageNr
        int currentPageNr = getPageNumber();
        Resources res = getResources();
        String[] questions = res.getStringArray(R.array.questions);
        int length = questions.length;

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_question_page, container, false);

       /* ((TextView) rootView.findViewById(R.id.txtQuestion)).setText(
                getString(R.string.question_one, mPageNumber + 1) + currentPageNr);*/
        ((TextView) rootView.findViewById(R.id.txtQuestion)).setText(questions[currentPageNr]);
        // not working
        ((TextView) rootView.findViewById(R.id.txtNavigation)).setText(R.string.navigation_help);

        return rootView;
    }

    public int getPageNumber() {
        return mPageNumber;
    }
}
