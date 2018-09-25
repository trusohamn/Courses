#include <iostream>
 using namespace std;
class Segment {
    double A,B;
    public:
    Segment(double A, double B) : A(A), B(B) { }

    friend Segment operator*(Segment seg, double d);
    friend Segment operator*(double d, Segment seg);
    friend Segment operator/(Segment seg, double d);
    friend Segment operator+(Segment seg, double d);
    friend Segment operator+(double d, Segment seg);
    friend Segment operator-(Segment seg, double d);
    friend Segment operator+(Segment seg1, Segment seg2);
    friend ostream& operator<<(ostream& str, const Segment& seg);
    bool operator()(double d)  {
         return (d>=A && d<=B);
    }
};

Segment operator*(Segment seg, double d) {
    return Segment(seg.A*d , seg.B*d);
}
Segment operator*(double d, Segment seg) {
    return Segment(seg.A*d , seg.B*d);
}
Segment operator/(Segment seg, double d) {
    return Segment(seg.A/d , seg.B/d);
}
Segment operator+(Segment seg, double d) {
    return Segment(seg.A+d , seg.B+d);
}
Segment operator+(double d, Segment seg) {
    return Segment(seg.A+d , seg.B+d);
}
Segment operator-(Segment seg, double d) {
    return Segment(seg.A-d , seg.B-d);
}
Segment operator+(Segment seg1, Segment seg2) {
    return Segment(seg1.A<seg2.A ? seg1.A : seg2.A , seg1.B<seg2.B ? seg2.B : seg1.B);
}
ostream& operator<<(ostream& str, const Segment& seg) {
 return str << "[" << seg.A << ", " << seg.B << "]" ;
      }

int main() {
    using std::cout; using std::endl;

    Segment seg{1,4}, s = 2 + 5*((seg-2)/3+seg)/seg;
    for (double x = 0.3; x < 6; x += 1)
        cout << "x=" << x << ": " << s(x) << endl;

}
