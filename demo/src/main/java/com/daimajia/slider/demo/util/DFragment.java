package com.daimajia.slider.demo.util;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.slider.demo.R;

public class DFragment extends DialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.layout_dlg, container,
				false);
		getDialog().setTitle("Please enter admin password");

		final EditText edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);

		Button btnOk = (Button)rootView.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(edtPassword.getText().toString())) {
					if (edtPassword.getText().toString().equals("9999")) {
						getActivity().finish();
						try {
							String[] cmd = {"su",
									"-c", "am start -a android.intent.action.MAIN -p com.google.android.leanbacklauncher"};
							Runtime.getRuntime().exec(cmd);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						Toast.makeText(getActivity(), "Invalid password, please try again!", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
		

		// Do something else
		return rootView;
	}
}