package com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.ui.containers.interfaces;

import android.view.View;

public interface IViewObserver {
	/**
	 * @param v View which is getting removed
	 * @param position View position in adapter
	 */
	void onViewRemovedFromParent(View v, int position);
}
