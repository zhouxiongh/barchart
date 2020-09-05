/*

 *****************************************************************************
 *  Name:              Jason He
 *  Coursera User ID:  null
 *  Last modified:     9/5/2020
 ****************************************************************************

 */

import java.util.Arrays;

public class BarChartRacer {

    public static Bar[] readGroup(In in) {
        int num = in.readInt();
        in.readLine();
        Bar[] bars = new Bar[num];
        for (int i = 0; i < num; i++) {
            String line = in.readLine();
            String[] strArr = line.split(",");
            String time = strArr[0];
            String city = strArr[1];
            int value = Integer.parseInt(strArr[3]);
            String category = strArr[4];


            bars[i] = new Bar(time, city, value, category);

        }
        return bars;
    }

    public static void main(String[] args) {

        int paueseTime = 100;

        String filename = args[0];

        int num = Integer.parseInt(args[1]);

        In in = new In(filename);

        // create the bar chart
        String title = in.readLine();

        String xAxis = in.readLine();

        String source = in.readLine();



        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        StdAudio.loop("soundtrackB.wav");




        for (;;) {
            BarChart chart = new BarChart(title, xAxis, source);

            // add the bars to the bar chart
            Bar[] bars = readGroup(in);
            chart.setCaption(bars[0].getTime());
            Arrays.sort(bars);

            for (int i = 0; i < num; i++) {
                chart.add(bars[i]);
            }

            // draw the bar chart

            if (bars[0].getValue() == 0) {
                continue;
            }

            chart.draw();
            StdDraw.show();
            StdDraw.pause(paueseTime);
            StdDraw.clear();

        }


    }
}
