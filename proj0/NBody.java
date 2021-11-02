import java.util.ArrayList;
import java.util.List;

public class NBody {
    private static String BACKGROUND = "advice.png";
    /** Given a file name as a String, it should return a double corresponding to the radius of the universe in that file **/
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    /** Given a file name, it should return an array of Bodys corresponding to the bodies in the file **/
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int len = in.readInt();
        in.readDouble();
        double Item1;
        double Item2;
        double Item3;
        double Item4;
        double Item5;
        String Item6;
        Planet[] res = new Planet[len];
        for (int i = 0;i < len;i++) {
            Item1 = in.readDouble();
            Item2 = in.readDouble();
            Item3 = in.readDouble();
            Item4 = in.readDouble();
            Item5 = in.readDouble();
            Item6 = in.readString();
            Planet planet = new Planet(Item1, Item2, Item3, Item4, Item5, Item6);
            res[i] = planet;
        }
        return res;
    }

    public static void main(String[] args) {
        Double t = Double.valueOf(args[0]);
        Double dt = Double.valueOf(args[1]);
        String fileName = args[2];
        double radius = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (Planet planet: planets) {
            planet.draw();
        }
        StdDraw.enableDoubleBuffering();
        double now = 0;
        int i = 0;
        while (now < t) {
            double xForces[] = new double[planets.length];
            double yForces[] = new double[planets.length];
            for(int j = 0; j < planets.length; j++) {
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for(int j = 0; j < planets.length; j++) {
                planets[j].update(dt,xForces[j],yForces[j]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            i++;
            now+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int g = 0; g < planets.length; g++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[g].xxPos, planets[g].yyPos, planets[g].xxVel,
                    planets[g].yyVel, planets[g].mass, planets[g].imgFileName);
        }
    }
}
