// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pop.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package teddy:
//            Modify, LinkedList, Vector2, Polyhedron, 
//            Teddy, Def, Generate, Vertex2D, 
//            Draw3DScene, SurfaceLine, Polygon2, Objects, 
//            Edge, Ring, Vertex, Vector3, 
//            Geometry, Surface, Line, Trianglation, 
//            Tessellation

class Pop extends Modify
{

    public static void pop(LinkedList linkedlist, Polyhedron polyhedron)
    {
        if(Vector2.distance((Point)linkedlist.head(), (Point)linkedlist.tail()) < 10D)
        {
            polyhedron.temp_surface_lines = new LinkedList();
            return;
        }
        Teddy.teddy.play_sound("pop.au");
        linkedlist = Generate.normalize_Point_list(linkedlist, Def.NORMALIZED_STROKE_LENGTH_POP);
        Modify.h = polyhedron;
        LinkedList linkedlist1 = new LinkedList();
        Point point;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); linkedlist1.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y))))
            point = (Point)enumeration.nextElement();

        linkedlist1 = Generate.normalize_Vertex2D_list(linkedlist1);
        linkedlist1 = Generate.reduce_Vertex2D_list(linkedlist1, false);
        Modify.h.max_part_index++;
        new_part_index = Modify.h.max_part_index;
        old_part_index = ((SurfaceLine)Modify.h.temp_surface_lines.head()).polygon.part_index;
        Modify.h.parent_of_a_part[new_part_index] = old_part_index;
        Modify.h.current_part_index = new_part_index;
        pop_main(linkedlist1);
    }

    private static void construct(LinkedList linkedlist)
    {
        if(!Modify.h.section_bumping)
        {
            Modify.section_is_sharp = true;
            Modify.h.current_part_index = old_part_index;
            divide_polygons_loop(Modify.h.temp_edge_vertex_list);
            Modify.h.current_part_index = new_part_index;
            Modify.delete_temp_polygons();
        } else
        {
            Modify.section_is_sharp = false;
            SurfaceLine surfaceline;
            for(Enumeration enumeration = Modify.h.temp_surface_lines.elements(); enumeration.hasMoreElements(); Modify.h.remove(surfaceline.polygon))
                surfaceline = (SurfaceLine)enumeration.nextElement();

            Edge edge;
            for(Enumeration enumeration1 = Modify.h.temp_edge_vertex_list.elements(); enumeration1.hasMoreElements(); edge.set_sharp(false))
                edge = (Edge)((Objects)enumeration1.nextElement()).get(0);

        }
        Enumeration enumeration2 = linkedlist.elements();
        Ring ring1;
        for(Ring ring = (Ring)enumeration2.nextElement(); enumeration2.hasMoreElements(); ring = ring1)
        {
            Object obj = enumeration2.nextElement();
            if(obj instanceof Vertex)
            {
                construct_top(ring, (Vertex)obj);
                break;
            }
            ring1 = (Ring)obj;
            construct_sub(ring, ring1);
        }

        Modify.h.temp_surface_lines = new LinkedList();
    }

    Pop()
    {
    }

    private static void construct_top(Ring ring, Vertex vertex)
    {
        Modify.h.append(vertex);
        Enumeration enumeration = ring.elements();
        Vertex vertex2;
        for(Vertex vertex1 = (Vertex)enumeration.nextElement(); enumeration.hasMoreElements(); vertex1 = vertex2)
        {
            vertex2 = (Vertex)enumeration.nextElement();
            Modify.h.append_a_new_polygon(vertex1, vertex2, vertex);
        }

    }

    private static LinkedList generate_rings(Ring ring, Vertex vertex, Vertex vertex1, LinkedList linkedlist, Vector3 vector3)
    {
        LinkedList linkedlist1 = new LinkedList();
        linkedlist1.append(ring);
        LinkedList linkedlist2 = linkedlist.reverse();
        Enumeration enumeration = linkedlist.elements();
        Enumeration enumeration1 = linkedlist2.elements();
        Vertex vertex2 = (Vertex)enumeration.nextElement();
        Vertex vertex3 = (Vertex)enumeration.nextElement();
        Vertex vertex4 = (Vertex)enumeration.nextElement();
        Vertex vertex5 = (Vertex)enumeration1.nextElement();
        Vertex vertex6 = (Vertex)enumeration1.nextElement();
        Vertex vertex7 = (Vertex)enumeration1.nextElement();
        do
        {
            Ring ring1 = Ring.sweep(ring, vertex, vertex1, vertex2, vertex5, vector3);
            linkedlist1.append(ring1);
            if(vertex3 == vertex6)
            {
                linkedlist1.append(vertex3);
                break;
            }
            if(vertex3 == vertex5)
            {
                linkedlist1.append(Vertex.mid_point(vertex2, vertex5));
                break;
            }
            Vector3 vector3_1 = (new Vector3(vertex2, vertex3)).get_normalized();
            Vector3 vector3_2 = (new Vector3(vertex3, vertex4)).get_normalized();
            Vector3 vector3_3 = (new Vector3(vertex5, vertex6)).get_normalized();
            Vector3 vector3_4 = (new Vector3(vertex6, vertex7)).get_normalized();
            vector3_1.add(vector3_4);
            vector3_2.add(vector3_3);
            vector3_2.add(vector3_4);
            Vector3 vector3_5 = new Vector3(vertex2, vertex6);
            Vector3 vector3_6 = new Vector3(vertex3, vertex5);
            Vector3 vector3_7 = new Vector3(vertex3, vertex6);
            double d = Math.max(Math.abs(vector3_5.cos(vector3_1)), Math.abs(vector3_5.cos(vector3_4)));
            double d1 = Math.max(Math.abs(vector3_6.cos(vector3_2)), Math.abs(vector3_6.cos(vector3_3)));
            double d2 = Math.max(Math.abs(vector3_7.cos(vector3_2)), Math.abs(vector3_7.cos(vector3_4)));
            if(d <= d1 && d <= d2)
            {
                vertex5 = vertex6;
                vertex6 = vertex7;
                vertex7 = (Vertex)enumeration1.nextElement();
                vertex2 = Vertex.mid_point(vertex2, vertex3);
            } else
            if(d1 <= d && d1 <= d2)
            {
                vertex2 = vertex3;
                vertex3 = vertex4;
                vertex4 = (Vertex)enumeration.nextElement();
                vertex5 = Vertex.mid_point(vertex5, vertex6);
            } else
            {
                vertex2 = vertex3;
                vertex3 = vertex4;
                vertex4 = (Vertex)enumeration.nextElement();
                vertex5 = vertex6;
                vertex6 = vertex7;
                vertex7 = (Vertex)enumeration1.nextElement();
            }
        } while(true);
        Enumeration enumeration2 = linkedlist1.elements();
        Ring ring3;
        for(Ring ring2 = (Ring)enumeration2.nextElement(); enumeration2.hasMoreElements(); ring2 = ring3)
        {
            Object obj = enumeration2.nextElement();
            if(obj instanceof Vertex)
                break;
            ring3 = (Ring)obj;
            if(((Vertex)ring2.head()).same_position((Vertex)ring3.head()))
            {
                ring3.replace_head(ring2.head());
                ring3.replace_tail(ring2.head());
            }
        }

        return linkedlist1;
    }

    protected static void divide_polygons_loop(LinkedList linkedlist)
    {
        Modify.init(Modify.h);
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Objects objects = (Objects)enumeration.nextElement();
        linkedlist1.append((Vertex)objects.get(1));
        Polygon2 polygon2_2 = (Polygon2)objects.get(0);
        Polygon2 polygon2_3 = polygon2_2;
        System.out.println("base " + polygon2_3);
        objects = new Objects();
        while(enumeration.hasMoreElements()) 
        {
            objects = (Objects)enumeration.nextElement();
            linkedlist1.append((Vertex)objects.get(1));
            if(objects.get(0) instanceof Edge)
                break;
        }
        if(!enumeration.hasMoreElements())
            return;
        Vertex vertex = (Vertex)objects.get(1);
        Edge edge = (Edge)objects.get(0);
        Polygon2 polygon2 = polygon2_2;
        polygon2_2 = edge.get_another_polygon(polygon2);
        Modify.h.append(vertex);
        LinkedList linkedlist3 = linkedlist1.reverse();
        Vertex vertex2 = vertex;
        Edge edge4 = edge;
        do
        {
            LinkedList linkedlist2 = new LinkedList();
            linkedlist2.append(vertex);
            while(enumeration.hasMoreElements()) 
            {
                objects = (Objects)enumeration.nextElement();
                linkedlist2.append((Vertex)objects.get(1));
                if(objects.get(0) instanceof Edge)
                    break;
            }
            if(enumeration.hasMoreElements())
            {
                Vertex vertex1 = (Vertex)objects.get(1);
                Edge edge1 = (Edge)objects.get(0);
                Polygon2 polygon2_1 = edge1.get_another_polygon(polygon2_2);
                Edge edge2 = edge1;
                if(polygon2_1 == null)
                {
                    edge1 = Modify.find_corresponding_edge(polygon2_2, edge1);
                    polygon2_1 = edge1.get_another_polygon(polygon2_2);
                }
                Edge edge3 = edge1;
                if(polygon2_1 == null)
                {
                    edge3 = edge2;
                    polygon2_1 = edge3.get_another_polygon(null);
                }
                if(edge == edge1)
                {
                    Modify.PolygonReplace polygonreplace = Modify.polygon_replace_manager.replaced(polygon2);
                    if(polygonreplace != null)
                    {
                        Edge edge5 = Modify.find_corresponding_edge(polygonreplace.child0, edge1);
                        Edge edge6 = Modify.find_corresponding_edge(polygonreplace.child1, edge1);
                        if(edge5.on_edge(vertex1))
                        {
                            edge3 = edge5;
                            polygon2_1 = polygonreplace.child0;
                        } else
                        {
                            edge3 = edge6;
                            polygon2_1 = polygonreplace.child1;
                        }
                    }
                }
                if(!polygon2_2.contains(edge1))
                    edge1 = Modify.polygon_replace_manager.get_corresponding_edge(edge1, vertex1);
                Modify.divide_a_polygon(polygon2_2, linkedlist2, vertex, edge, vertex1, edge1);
                polygon2 = polygon2_2;
                vertex = vertex1;
                edge = edge3;
                polygon2_2 = polygon2_1;
                Modify.h.append(vertex);
            } else
            {
                Modify.divide_knot_polygon(polygon2_3, vertex, edge, linkedlist2, vertex2, edge4, linkedlist3);
                return;
            }
        } while(true);
    }

    private static void construct_sub(Ring ring, Ring ring1)
    {
        Enumeration enumeration = ring1.elements();
        enumeration.nextElement();
        for(; enumeration.hasMoreElements(); Modify.h.append((Vertex)enumeration.nextElement()));
        Enumeration enumeration1 = ring.elements();
        Enumeration enumeration2 = ring1.elements();
        Vertex vertex = (Vertex)enumeration1.nextElement();
        Vertex vertex1 = (Vertex)enumeration2.nextElement();
        if(ring.size() != ring1.size())
        {
            Vertex vertex2 = (Vertex)enumeration1.nextElement();
            Vertex vertex4 = (Vertex)enumeration2.nextElement();
            while(enumeration1.hasMoreElements() || enumeration2.hasMoreElements()) 
            {
                Vector3 vector3 = new Vector3(vertex1, vertex4);
                Vector3 vector3_1 = new Vector3(vertex, vertex2);
                Vector3 vector3_2 = new Vector3(vertex, vertex4);
                Vector3 vector3_3 = new Vector3(vertex1, vertex2);
                double d = Math.min(Math.abs(vector3_2.sin(vector3)), Math.abs(vector3_2.sin(vector3_1)));
                double d1 = Math.min(Math.abs(vector3_3.sin(vector3)), Math.abs(vector3_3.sin(vector3_1)));
                if(d1 > d || !enumeration2.hasMoreElements())
                {
                    Modify.h.append_a_new_polygon(vertex, vertex2, vertex1);
                    vertex = vertex2;
                    vertex2 = (Vertex)enumeration1.nextElement();
                } else
                {
                    Modify.h.append_a_new_polygon(vertex4, vertex1, vertex);
                    vertex1 = vertex4;
                    vertex4 = (Vertex)enumeration2.nextElement();
                }
            }
            Modify.h.append_a_new_polygon(vertex, vertex2, vertex1);
            Modify.h.append_a_new_polygon(vertex4, vertex1, vertex2);
            return;
        }
        while(enumeration1.hasMoreElements()) 
        {
            Vertex vertex3 = (Vertex)enumeration1.nextElement();
            Vertex vertex5 = (Vertex)enumeration2.nextElement();
            if(vertex3.distance(vertex1) < vertex.distance(vertex5))
            {
                Modify.h.append_a_new_polygon(vertex, vertex3, vertex1);
                Modify.h.append_a_new_polygon(vertex5, vertex1, vertex3);
            } else
            {
                Modify.h.append_a_new_polygon(vertex, vertex3, vertex5);
                Modify.h.append_a_new_polygon(vertex5, vertex1, vertex);
            }
            vertex = vertex3;
            vertex1 = vertex5;
        }
    }

    public static void pop_main(LinkedList linkedlist)
    {
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex);
        Vector3 vector3 = new Vector3(0.0D, 0.0D, 0.0D);
        Enumeration enumeration = Modify.h.temp_surface_lines.elements();
        Vector3 vector3_3;
        for(Vector3 vector3_2 = ((SurfaceLine)enumeration.nextElement()).vector3(); enumeration.hasMoreElements(); vector3_2 = vector3_3)
        {
            vector3_3 = ((SurfaceLine)enumeration.nextElement()).vector3();
            Vector3 vector3_1 = vector3_2.cross_product(vector3_3);
            vector3.add_self(vector3_1);
        }

        vector3.normalize();
        Vertex vertex1 = new Vertex(0.0D, 0.0D, 0.0D);
        SurfaceLine surfaceline;
        for(enumeration = Modify.h.temp_surface_lines.elements(); enumeration.hasMoreElements(); vertex1.add_self(((Edge) (surfaceline)).start))
            surfaceline = (SurfaceLine)enumeration.nextElement();

        vertex1.multiple_self(1.0D / (double)Modify.h.temp_surface_lines.size());
        Modify.h.pivot_of_a_part[Modify.h.current_part_index] = vertex1;
        Modify.h.normal_of_a_part[Modify.h.current_part_index] = vector3;
        Vector3 vector3_4 = new Vector3(vertex, vertex1);
        Vector3 vector3_5 = vector3.cross_product(vector3_4);
        enumeration = Modify.h.temp_surface_lines.elements();
        Vertex vertex2 = ((Edge) ((SurfaceLine)enumeration.nextElement())).start;
        Vector3 vector3_6 = new Vector3(vertex1, vertex2);
        double d = vector3_5.dot_product(vector3_6);
        Vertex vertex5 = vertex2;
        Vertex vertex6 = vertex2;
        double d2 = d;
        double d3 = d;
        while(enumeration.hasMoreElements()) 
        {
            Vertex vertex3 = ((Edge) ((SurfaceLine)enumeration.nextElement())).start;
            Vector3 vector3_7 = new Vector3(vertex1, vertex3);
            double d1 = vector3_5.dot_product(vector3_7);
            if(d1 > d2)
            {
                d2 = d1;
                vertex5 = vertex3;
            }
            if(d1 < d3)
            {
                d3 = d1;
                vertex6 = vertex3;
            }
        }
        Surface surface = new Surface(vertex1, vector3.cross_product(vector3.cross_product(vector3_4)));
        LinkedList linkedlist1 = new LinkedList();
        Vertex vertex4;
        for(Enumeration enumeration1 = linkedlist.elements(); enumeration1.hasMoreElements(); linkedlist1.append(surface.cross_point(new Edge(vertex, vertex4))))
            vertex4 = Draw3DScene.image_plane_to_world_coords((Vertex2D)enumeration1.nextElement());

        System.out.println(linkedlist1.size());
        Ring ring = new Ring(Modify.h.temp_edge_vertex_list);
        double d4 = Vector3.distance(vertex6, (Vertex)linkedlist1.head());
        double d5 = Vector3.distance(vertex6, (Vertex)linkedlist1.tail());
        Vertex vertex7;
        Vertex vertex8;
        if(d4 < d5)
        {
            vertex7 = vertex6;
            vertex8 = vertex5;
        } else
        {
            vertex7 = vertex5;
            vertex8 = vertex6;
        }
        Line line = new Line(vertex1, vector3.cross_product(vector3_4));
        vertex7 = line.get_foot(vertex7);
        vertex8 = line.get_foot(vertex8);
        LinkedList linkedlist2 = generate_rings(ring, vertex7, vertex8, linkedlist1, vector3);
        construct(linkedlist2);
        Modify.remove_broken_polygons();
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
    }

    private static int old_part_index;
    private static int new_part_index;
}
