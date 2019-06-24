package com.obpoo.gfsfabricsoftware.ui.fragment;

import android.app.Dialog;
import android.support.v4.app.Fragment;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;



public class BaseFragment extends Fragment {

    private Dialog progressDialog;

    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getActivity(), getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getActivity(), getString(R.string.loading_please_wait));
        }
    }

    public void closeProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
