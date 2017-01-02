/*
 *  This file is part of GMPtest, and Android app used to verify GMP builds.
 *  Copyright (C) 2015 Michael Mohr <akihana@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gmplib.tests;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class TestDriver extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random r = new Random();
        int int_a = r.nextInt(100);
        int int_b = r.nextInt(100);
        String sum = add(String.valueOf(int_a), String.valueOf(int_b), 10);

        TextView tv = new TextView(this);
        tv.setText("The sum of " + int_a + " and " + int_b + " is " + sum);
        setContentView(tv);
    }

    public native String add(String a, String b, int base);

    static {
        System.loadLibrary("gmp");
        System.loadLibrary("gmp-tests");
    }
}