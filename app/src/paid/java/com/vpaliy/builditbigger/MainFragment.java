import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vpaliy.builditbigger.BaseMainFragment;
import com.vpaliy.builditbigger.R;

public class MainFragment extends BaseMainFragment {

    @Override
    public void onJokeFetched(final String joke) {
        super.onJokeFetched(joke);
        showJoke(joke);
    }
}
