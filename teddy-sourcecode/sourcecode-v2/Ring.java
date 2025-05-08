// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pop.java

package teddy;

import java.util.Enumeration;

// Referenced classes of package teddy:
//            LinkedList, Objects, Vertex, Vector3, 
//            Generate

class Ring extends LinkedList
{

    Ring(LinkedList linkedlist)
    {
        this();
        Objects objects;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); append((Vertex)objects.get(1)))
            objects = (Objects)enumeration.nextElement();

    }

    Ring()
    {
    }

    public static Ring linked_list_to_ring(LinkedList linkedlist)
    {
        Ring ring = new Ring();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); ring.append(enumeration.nextElement()));
        return ring;
    }

    public static Ring sweep(Ring ring, Vertex vertex, Vertex vertex1, Vertex vertex2, Vertex vertex3, Vector3 vector3)
    {
        Ring ring1 = new Ring();
        Vector3 vector3_1 = new Vector3(vertex, vertex1);
        Vector3 vector3_2 = vector3_1.cross_product(vector3);
        Vector3 vector3_3 = vector3_1.cross_product(vector3_2);
        Vector3 vector3_4 = new Vector3(vertex2, vertex3);
        Vector3 vector3_5 = vector3_2;
        Vector3 vector3_6 = vector3_4.cross_product(vector3_5);
        double d = vector3_4.length() / vector3_1.length();
        vector3_1.normalize();
        vector3_2.normalize();
        vector3_3.normalize();
        vector3_4.normalize();
        vector3_5.normalize();
        vector3_6.normalize();
        Vertex vertex5;
        for(Enumeration enumeration = ring.elements(); enumeration.hasMoreElements(); ring1.append(vertex5))
        {
            Vertex vertex4 = ((Vertex)enumeration.nextElement()).copy();
            Vector3 vector3_7 = new Vector3(vertex, vertex4);
            double d1 = vector3_1.dot_product(vector3_7);
            double d2 = vector3_2.dot_product(vector3_7);
            double d3 = vector3_3.dot_product(vector3_7);
            Vector3 vector3_8 = new Vector3(0.0D, 0.0D, 0.0D);
            vector3_8.add_self(vector3_4.multiple(d1 * d));
            vector3_8.add_self(vector3_5.multiple(d2 * d));
            vector3_8.add_self(vector3_6.multiple(d3 * d));
            vertex5 = vertex2.shift(vector3_8);
        }

        ring1 = linked_list_to_ring(Generate.reduce_Vertex_list(ring1));
        ring1.replace_tail(ring1.head());
        return ring1;
    }
}
