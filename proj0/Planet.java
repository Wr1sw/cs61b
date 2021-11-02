import java.lang.Math.*;
import java.math.BigDecimal;

public class Planet {
    public static final double G = 6.67e-11;
    /**
     * its current x position
     **/
    public double xxPos;

    /**
     * its current y position
     **/
    public double yyPos;

    /**
     * its current velocity in the x direction
     **/
    public double xxVel;

    /**
     * its current velocity in the y direction
     **/
    public double yyVel;

    /**
     * its masspublic
     **/
    public double mass;

    /**
     * the name of the file that corresponds to the image that depicts the body
     **/
    String imgFileName;

    public Planet() {
    }

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    //    (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)*(y1-y2)
    public double calcDistance(Planet target) {
        double res = (xxPos - target.xxPos) * (xxPos - target.xxPos) + (yyPos - target.yyPos) * (yyPos - target.yyPos);
        return Math.sqrt(res);
    }

    //    Gm1m2/r*r
    public double calcForceExertedBy(Planet target) {
        double res = (G * mass* target.mass) / (calcDistance(target) * calcDistance(target));
        return res;
    }

    public double calcForceExertedByX(Planet target) {
        double xx = target.xxPos - xxPos;
//        if (xxPos > target.xxPos) {
//            xx = xxPos-target.xxPos;
//        }else {
//            xx = target.xxPos - xxPos;
//        }
        double res = calcForceExertedBy(target) * (xx/calcDistance(target));
        return res;
    }

    public double calcForceExertedByY(Planet target) {
        double yy = target.yyPos - yyPos;
//        if (yyPos > target.yyPos) {
//            yy = yyPos-target.yyPos;
//        }else {
//            yy = target.yyPos - yyPos;
//        }
        double res = calcForceExertedBy(target) * (yy/calcDistance(target));
        return res;
    }

    public double calcNetForceExertedByX(Planet[] target) {
        double res = 0;
        for (Planet planet : target) {
            if (planet.equals(this)) {
                continue;
            }
            res += calcForceExertedByX(planet);
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] target) {
        double res = 0;
        for (Planet planet : target) {
            if (planet.equals(this)) {
                continue;
            }
            res += calcForceExertedByY(planet);
        }
        return res;
    }

    public void update(double t, double fx, double fy) {
        double ax = fx / this.mass, ay = fy / this.mass;
        this.xxVel = xxVel + t * ax;
        this.yyVel += t*ay;
        this.xxPos += t*xxVel;
        this.yyPos += t*yyVel;
}

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "xxPos=" + xxPos +
                ", yyPos=" + yyPos +
                ", xxVel=" + xxVel +
                ", yyVel=" + yyVel +
                ", mass=" + mass +
                ", imgFileName='" + imgFileName + '\'' +
                '}';
    }
}