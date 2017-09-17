/**
 * Created by GrasFish on 2017/9/16.
 */

import org.omg.PortableServer.POA;

import java.util.regex.*;

class Polynomial {

    private class Node {
        float cofficient;
        int exponent;
        Node next;

        Node(float cofficient, int exponent) {
            this.cofficient = cofficient;
            this.exponent = exponent;
            this.next = null;
        }

        Node() {
            this.cofficient = 0f;
            this.exponent = 0;
            this.next = null;
        }
    }

    private Node head;

    public Polynomial() {
        head = new Node();
    }

    void appendToTail(float cof, int exp) {
        Node p = head;
        Node last = new Node(cof, exp);
        while (p.next != null) {
            p = p.next;
        }
        p.next = last;
    }

    boolean isTail(Node node) {
        return node.next == null;
    }

    Polynomial plus(Polynomial poly2) {
        Polynomial polynomial3 = new Polynomial();
        Polynomial polynomial1 = this;
        Polynomial polynomial2 = poly2;
        Node p1 = polynomial1.head.next;
        Node p2 = polynomial2.head.next;

        while (p1 != null && p2 != null) {
            if (p1.exponent > p2.exponent) {
                polynomial3.appendToTail(p1.cofficient, p1.exponent);
                p1 = p1.next;
            } else if (p1.exponent == p2.exponent && p1.cofficient + p2.cofficient != 0) {
                polynomial3.appendToTail(p1.cofficient + p2.cofficient, p1.exponent);
                p1 = p1.next;
                p2 = p2.next;
            } else {
                polynomial3.appendToTail(p2.cofficient, p2.exponent);
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            polynomial3.appendToTail(p1.cofficient, p1.exponent);
            p1 = p1.next;
        }
        while (p2 != null) {
            polynomial3.appendToTail(p2.cofficient, p2.exponent);
            p2 = p2.next;
        }


        return polynomial3;
    }

    void optimize() {
        Node p = head.next;
        Node q = new Node();
        while (p.next != null) {
            if (p.exponent == p.next.exponent) {
                p.cofficient = p.cofficient + p.next.cofficient;
                p.next = p.next.next;
                p = head.next;
            } else p = p.next;
        }
    }

    void sortPoly() {
        if (head == null || head.next == null) return;
        Node p, q;
        for (p = head.next; p != null; p = p.next) {
            for (q = p.next; q != null; q = q.next) {
                if (p.exponent < q.exponent) {
                    float c = p.cofficient;
                    int e = p.exponent;
                    p.cofficient = q.cofficient;
                    p.exponent = q.exponent;
                    q.cofficient = c;
                    q.exponent = e;
                }
            }
        }
        optimize();
    }

    void printPolyList() {
        System.out.println();
        Node p = head;
        while (p.next != null) {
            p = p.next;
            if (p != head.next) {
                if (p.cofficient > 0) {
                    if (p.exponent == 0) {
                        System.out.print(" + " + p.cofficient);
                    } else {
                        System.out.print(" + " + p.cofficient + "x^" + p.exponent);
                    }
                } else if (p.cofficient < 0) {
                    if (p.exponent == 0) {
                        System.out.print(" - " + Math.abs(p.cofficient));
                    } else {
                        System.out.print(" - " + Math.abs(p.cofficient) + "x^" + p.exponent);
                    }
                }
            } else {
                if (p.cofficient != 0)
                    System.out.print(p.cofficient + "x^" + p.exponent);
                else
                    System.out.print(p.cofficient);
            }
        }
        System.out.println();
    }

    void createList(String polyList) {
        Pattern pattern = Pattern.compile("\\+");
        String[] arr = pattern.split(polyList);
        for (String item : arr) {
            float cof = 0f;
            int exp = 0;
            cof = getCof(item);
            exp = getExp(item);
            appendToTail(cof, exp);
        }
        sortPoly();
    }

    float getCof(String item) {
        String[] ss = Pattern.compile("[x^]").split(item);
        return Float.parseFloat(ss[0]);
    }

    int getExp(String item) {
        String[] ss = Pattern.compile("[x^]").split(item);
        return Integer.parseInt(ss[2]);
    }

    int length() {
        Node p = head;
        int count = 0;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        return count;
    }
}
