package com.devpicon.android.customviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by armando on 8/13/16.
 */
public class MainPagerAdapter extends PagerAdapter {

    private static final String TAG = MainPagerAdapter.class.getSimpleName();

    private ArrayList<View> views = new ArrayList<>();

    @Override
    public int getItemPosition(Object object) {
        Log.d(TAG, "Ingreso a getItemPosition");
        int index = views.indexOf(object);
        if (index == -1) {
            return POSITION_NONE;
        }

        return index;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "Ingreso a instantiateItem");
        View v = views.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    public int addView(View v) {
        return addView(v, views.size());
    }

    /**
     * Agrega una vista en la posición recibida.
     * <p/>
     * La app deberá invocar a esta función para obtener una vista.
     *
     * @param v
     * @param position
     * @return
     */
    public int addView(View v, int position) {
        views.add(position, v);
        return position;
    }

    /**
     * Remueve la vista.
     * <p/>
     * La app deberá invocar a esta función para obtener una vista.
     *
     * @param pager
     * @param v
     * @return
     */
    public int removeView(ViewPager pager, View v) {
        return removeView(pager, views.indexOf(v));
    }

    /**
     * Remueve la vista ubicada en la posición recibida.
     * <p/>
     * ViewPager no cuenta con una función eliminar; lo más cercano es establecer el adapter de
     * nuevo. Al hacerlo eliminar todas sus vistas. Entonces, podemos eliminar la vista de la
     * lista y volver a establecer el adapter.
     * <p/>
     * La app deberá invocar a esta función para obtener una vista.
     *
     * @param pager
     * @param position
     * @return
     */
    public int removeView(ViewPager pager, int position) {
        Log.d(TAG, "Ingreso a removeView");
        pager.setAdapter(null);
        views.remove(position);
        pager.setAdapter(this);

        return position;
    }

    /**
     * Retorna la vista desde la posición recibida
     * La app deberá invocar a esta función para obtener una vista.
     *
     * @param position
     * @return vista
     */
    public View getView(int position) {
        Log.d(TAG, "Ingreso a getView");
        return views.get(position);
    }

    @Override
    public int getCount() {
        Log.d(TAG, "Ingreso a getCount");
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        Log.d(TAG, "Ingreso a isViewFromObject");
        return view == object;
    }
}
