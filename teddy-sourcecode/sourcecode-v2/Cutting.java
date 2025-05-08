// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cutting.java

package teddy;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Modify, LinkedList, Objects, Edge, 
//            Vertex, Polyhedron, Polygon2, SurfaceLine, 
//            Draw3DScene, Geometry, Vertex2D, Tessellation, 
//            Trianglation, Vector3, Teddy, Def, 
//            Generate

class Cutting extends Modify
{

    private static LinkedList get_edge_vertices(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements();)
        {
            Objects objects = (Objects)enumeration.nextElement();
            if(objects.get(0) instanceof Edge)
                linkedlist1.append((Vertex)objects.get(1));
        }

        return linkedlist1;
    }

    private static void generate_temp_edge_vertex_list(LinkedList linkedlist, LinkedList linkedlist1, LinkedList linkedlist2, LinkedList linkedlist3, Vector vector)
    {
        Modify.h.temp_edge_vertex_list = new LinkedList();
        generate_temp_edge_vertex_list(linkedlist, vector);
        generate_temp_edge_vertex_list(linkedlist1, vector);
        generate_temp_edge_vertex_list(linkedlist2, vector);
        generate_temp_edge_vertex_list(linkedlist3, vector);
        Modify.h.temp_edge_vertex_list.append(Modify.h.temp_edge_vertex_list.head());
    }

    private static void generate_temp_edge_vertex_list(LinkedList linkedlist, Vector vector)
    {
        Enumeration enumeration = linkedlist.elements();
        Vertex vertex1;
        for(Vertex vertex = find_corresponding_vertex((Vertex)((Objects)enumeration.nextElement()).get(1), vector); enumeration.hasMoreElements(); vertex = vertex1)
        {
            vertex1 = find_corresponding_vertex((Vertex)((Objects)enumeration.nextElement()).get(1), vector);
            if(vertex != vertex1)
            {
                Edge edge = vertex.get_shared_edge(vertex1);
                if(edge == null)
                    System.out.println("Cutting, OOOOOOOPS");
                Modify.h.temp_edge_vertex_list.append(new Objects(edge, vertex));
            }
        }

    }

    private static Objects divide_polygons(LinkedList linkedlist)
    {
        LinkedList linkedlist1 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex2 = (Vertex)objects.get(1);
        linkedlist1.append(vertex2);
        Polygon2 polygon2_2 = (Polygon2)objects.get(0);
        objects = new Objects();
        while(enumeration.hasMoreElements()) 
        {
            objects = (Objects)enumeration.nextElement();
            linkedlist1.append((Vertex)objects.get(1));
            if(objects.get(0) instanceof Edge)
                break;
        }
        if(!enumeration.hasMoreElements())
            return new Objects(null, null, linkedlist1, null, null, null);
        Vertex vertex = (Vertex)objects.get(1);
        Edge edge = (Edge)objects.get(0);
        Polygon2 polygon2 = polygon2_2;
        System.out.println("divide polygons--");
        Modify.PolygonReplace polygonreplace = Modify.polygon_replace_manager.replaced(polygon2);
        if(polygonreplace != null)
        {
            polygon2 = Modify.polygon_replace_manager.get_corresponding_polygon(polygonreplace, vertex2);
            edge = Modify.find_corresponding_edge(polygon2, edge);
        }
        polygon2_2 = edge.get_another_polygon(polygon2);
        if(polygon2_2 == null)
        {
            edge = Modify.polygon_replace_manager.get_corresponding_edge(edge, vertex);
            polygon2_2 = edge.get_another_polygon(null);
            if(polygon2_2 == polygon2)
            {
                System.out.println("from divided to not-divied (Cutting.divide_polygons)");
                edge = (Edge)objects.get(0);
                polygon2_2 = edge.get_another_polygon(null);
            }
        }
        Modify.h.append(vertex);
        LinkedList linkedlist3 = linkedlist1.reverse();
        Vertex vertex3 = vertex;
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
                    System.out.println("into polygon not divided");
                }
                if(edge == edge1)
                {
                    Modify.PolygonReplace polygonreplace1 = Modify.polygon_replace_manager.replaced(polygon2);
                    if(polygonreplace1 != null)
                    {
                        Edge edge5 = Modify.find_corresponding_edge(polygonreplace1.child0, edge1);
                        Edge edge6 = Modify.find_corresponding_edge(polygonreplace1.child1, edge1);
                        if(edge5.on_edge(vertex1))
                        {
                            edge3 = edge5;
                            polygon2_1 = polygonreplace1.child0;
                        } else
                        {
                            edge3 = edge6;
                            polygon2_1 = polygonreplace1.child1;
                        }
                        System.out.println("U turn");
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
                return new Objects(vertex3, edge4, linkedlist3, vertex, edge, linkedlist2);
            }
        } while(true);
    }

    private static void draw_surface_lines(LinkedList linkedlist, Polygon2 polygon2, Vertex vertex)
    {
        Enumeration enumeration = linkedlist.elements();
        enumeration.nextElement();
        while(enumeration.hasMoreElements()) 
        {
            Objects objects = (Objects)enumeration.nextElement();
            Vertex vertex1 = (Vertex)objects.get(1);
            Modify.h.temp_surface_lines.append(new SurfaceLine(vertex.copy(), vertex1.copy(), polygon2));
            if(objects.get(0) instanceof Edge)
            {
                Edge edge = (Edge)objects.get(0);
                polygon2 = edge.get_another_polygon(polygon2);
            }
            vertex = vertex1.copy();
        }
    }

    private static double get_average_length(LinkedList linkedlist, LinkedList linkedlist1, LinkedList linkedlist2, LinkedList linkedlist3)
    {
        double d = 0.0D;
        d += get_average_length_sub(linkedlist);
        d += get_average_length_sub(linkedlist1);
        d += get_average_length_sub(linkedlist2);
        d += get_average_length_sub(linkedlist3);
        return d / (double)(linkedlist.size() + linkedlist1.size() + linkedlist2.size() + linkedlist3.size());
    }

    Cutting()
    {
    }

    private static void generate_section_surface(LinkedList linkedlist, LinkedList linkedlist1)
    {
        LinkedList linkedlist2 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex = (Vertex)objects.get(1);
        Vertex vertex1 = vertex;
        while(enumeration.hasMoreElements()) 
        {
            Objects objects1 = (Objects)enumeration.nextElement();
            Vertex vertex2 = (Vertex)objects1.get(1);
            Edge edge = Modify.h.get_edge_array(vertex, vertex2);
            linkedlist2.append(edge);
            vertex = vertex2;
        }
        Edge edge1 = Modify.h.get_edge_array(vertex, vertex1);
        linkedlist2.append(edge1);
        Polygon2 polygon2 = new Polygon2(linkedlist2);
        Modify.h.append(polygon2);
        linkedlist1.append(edge1);
    }

    private static void generate_section_surface(LinkedList linkedlist, LinkedList linkedlist1, LinkedList linkedlist2)
    {
        Enumeration enumeration = linkedlist.elements();
        Enumeration enumeration1 = linkedlist1.elements();
        Vertex vertex1 = null;
        Objects objects = (Objects)enumeration.nextElement();
        Vertex vertex2 = (Vertex)objects.get(1);
        objects = (Objects)enumeration1.nextElement();
        Vertex vertex4 = (Vertex)objects.get(1);
        Edge edge;
        for(; enumeration.hasMoreElements(); linkedlist2.append(edge))
        {
            Vertex vertex = vertex2;
            LinkedList linkedlist4 = new LinkedList();
            while(enumeration.hasMoreElements()) 
            {
                Objects objects1 = (Objects)enumeration.nextElement();
                vertex1 = (Vertex)objects1.get(1);
                linkedlist4.append(Modify.h.get_edge_array(vertex, vertex1));
                if(objects1.get(0) instanceof Polygon2)
                    break;
                vertex = vertex1;
            }
            Vertex vertex3 = vertex1;
            vertex = vertex4;
            LinkedList linkedlist5 = new LinkedList();
            while(enumeration1.hasMoreElements()) 
            {
                Objects objects2 = (Objects)enumeration1.nextElement();
                vertex1 = (Vertex)objects2.get(1);
                linkedlist5.append(Modify.h.get_edge_array(vertex, vertex1));
                if(objects2.get(0) instanceof Polygon2)
                    break;
                vertex = vertex1;
            }
            Vertex vertex5 = vertex1;
            edge = Modify.h.get_edge_array(vertex4, vertex2);
            Edge edge1 = Modify.h.get_edge_array(vertex3, vertex5);
            LinkedList linkedlist3 = new LinkedList();
            linkedlist3.append(edge);
            linkedlist3.connect(linkedlist4);
            linkedlist3.append(edge1);
            linkedlist3.connect(linkedlist5.reverse());
            Modify.h.append(new Polygon2(linkedlist3));
            vertex2 = vertex3;
            vertex4 = vertex5;
        }

    }

    private static void generate_section_surface(Vertex vertex, Vertex vertex1, Vertex vertex2, Vertex vertex3)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.append(Modify.h.get_edge_array(vertex, vertex1));
        linkedlist.append(Modify.h.get_edge_array(vertex1, vertex2));
        linkedlist.append(Modify.h.get_edge_array(vertex2, vertex3));
        linkedlist.append(Modify.h.get_edge_array(vertex3, vertex));
        Modify.h.append(new Polygon2(linkedlist));
    }

    private static void generate_section_surface(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.append(Modify.h.get_edge_array(vertex, vertex1));
        linkedlist.append(Modify.h.get_edge_array(vertex1, vertex2));
        linkedlist.append(Modify.h.get_edge_array(vertex2, vertex));
        Modify.h.append(new Polygon2(linkedlist));
    }

    public static boolean cut_main(LinkedList linkedlist, boolean flag)
    {
        Vertex vertex = Draw3DScene.camera;
        Geometry.init(Modify.h, vertex);
        LinkedList linkedlist1 = new LinkedList();
        LinkedList linkedlist2 = new LinkedList();
        Enumeration enumeration = linkedlist.elements();
        Vertex2D vertex2d = (Vertex2D)enumeration.nextElement();
        if(Geometry.find_vertex_on_surface(vertex2d, true) != null)
            return false;
        Vertex2D vertex2d1;
        Objects objects;
        do
        {
            if(!enumeration.hasMoreElements())
            {
                System.out.println("invalid cutting stroke");
                return true;
            }
            vertex2d1 = (Vertex2D)enumeration.nextElement();
            objects = Geometry.find_vertex_on_surface(vertex2d1, true);
            if(objects != null)
                break;
            vertex2d = vertex2d1;
        } while(true);
        Vertex2D vertex2d2 = vertex2d;
        Vertex2D vertex2d4 = vertex2d1;
        Polygon2 polygon2_1 = (Polygon2)objects.get(0);
        Vertex vertex2 = (Vertex)objects.get(1);
        linkedlist1.append(objects);
        Objects objects1 = cut_sub(linkedlist1, enumeration, polygon2_1, vertex2d1, vertex2, true);
        Polygon2 polygon2 = (Polygon2)objects1.get(0);
        Vertex vertex1 = (Vertex)objects1.get(1);
        vertex2d = (Vertex2D)objects1.get(2);
        vertex2d1 = (Vertex2D)objects1.get(3);
        Vertex2D vertex2d3 = vertex2d1;
        Vertex2D vertex2d5 = vertex2d;
        Polygon2 polygon2_3 = polygon2;
        Vertex vertex4 = vertex1;
        for(enumeration = linkedlist.elements(); vertex2d2 != (Vertex2D)enumeration.nextElement(););
        vertex2d1 = (Vertex2D)enumeration.nextElement();
        objects = Geometry.find_vertex_on_surface(vertex2d1, false);
        Polygon2 polygon2_2 = (Polygon2)objects.get(0);
        Vertex vertex3 = (Vertex)objects.get(1);
        linkedlist2.append(objects);
        objects1 = cut_sub(linkedlist2, enumeration, polygon2_2, vertex2d1, vertex3, false);
        polygon2 = (Polygon2)objects1.get(0);
        vertex1 = (Vertex)objects1.get(1);
        vertex2d = (Vertex2D)objects1.get(2);
        vertex2d1 = (Vertex2D)objects1.get(3);
        if(vertex2d3 != vertex2d1 || vertex2d5 != vertex2d)
        {
            System.out.println("front back cutting mismatch");
            return false;
        }
        Polygon2 polygon2_4 = polygon2;
        Vertex vertex5 = vertex1;
        LinkedList linkedlist3 = new LinkedList();
        LinkedList linkedlist4 = new LinkedList();
        linkedlist3.append(new Objects(polygon2_1, vertex2));
        linkedlist3.connect(Geometry.surface_path(vertex2d4, vertex2d2, vertex2, vertex3, polygon2_1, polygon2_2));
        linkedlist3.append(new Objects(polygon2_2, vertex3));
        linkedlist4.append(new Objects(polygon2_3, vertex4));
        linkedlist4.connect(Geometry.surface_path(vertex2d5, vertex2d3, vertex4, vertex5, polygon2_3, polygon2_4));
        linkedlist4.append(new Objects(polygon2_4, vertex5));
        if(flag)
        {
            draw_surface_lines(linkedlist1, polygon2_1, vertex2);
            draw_surface_lines(linkedlist2, polygon2_2, vertex3);
            draw_surface_lines(linkedlist3, polygon2_1, vertex2.copy());
            draw_surface_lines(linkedlist4, polygon2_3, vertex4.copy());
            Modify.h.surface_lines.connect(Modify.h.temp_surface_lines);
            Modify.h.temp_surface_lines = new LinkedList();
            return false;
        }
        Modify.h.current_part_index = polygon2_1.part_index;
        Modify.section_is_sharp = true;
        Objects objects2 = divide_polygons(linkedlist1);
        Objects objects3 = divide_polygons(linkedlist2.reverse());
        Objects objects4 = divide_polygons(linkedlist3.reverse());
        Objects objects5 = divide_polygons(linkedlist4);
        if(objects2.get(0) != null)
        {
            Modify.divide_knot_polygon(polygon2_1, (Vertex)objects4.get(3), (Edge)objects4.get(4), (LinkedList)objects4.get(5), (Vertex)objects2.get(0), (Edge)objects2.get(1), (LinkedList)objects2.get(2));
            Modify.divide_knot_polygon(polygon2_3, (Vertex)objects2.get(3), (Edge)objects2.get(4), (LinkedList)objects2.get(5), (Vertex)objects5.get(0), (Edge)objects5.get(1), (LinkedList)objects5.get(2));
        } else
        {
            LinkedList linkedlist5 = (LinkedList)objects4.get(5);
            linkedlist5.connect(((LinkedList)objects2.get(2)).cdr());
            Modify.divide_knot_polygon(polygon2_1, (Vertex)objects4.get(3), (Edge)objects4.get(4), linkedlist5, (Vertex)objects5.get(0), (Edge)objects5.get(1), (LinkedList)objects5.get(2));
        }
        if(objects3.get(0) != null)
        {
            Modify.divide_knot_polygon(polygon2_2, (Vertex)objects3.get(3), (Edge)objects3.get(4), (LinkedList)objects3.get(5), (Vertex)objects4.get(0), (Edge)objects4.get(1), (LinkedList)objects4.get(2));
            Modify.divide_knot_polygon(polygon2_4, (Vertex)objects5.get(3), (Edge)objects5.get(4), (LinkedList)objects5.get(5), (Vertex)objects3.get(0), (Edge)objects3.get(1), (LinkedList)objects3.get(2));
        } else
        {
            LinkedList linkedlist6 = (LinkedList)objects5.get(5);
            linkedlist6.connect(((LinkedList)objects3.get(2)).cdr());
            Modify.divide_knot_polygon(polygon2_4, (Vertex)objects5.get(3), (Edge)objects5.get(4), (LinkedList)objects5.get(5), (Vertex)objects4.get(0), (Edge)objects4.get(1), (LinkedList)objects4.get(2));
        }
        Modify.delete_temp_polygons();
        LinkedList linkedlist7 = new LinkedList();
        generate_section_surface(linkedlist3.reverse(), linkedlist7);
        linkedlist7 = new LinkedList();
        generate_section_surface(linkedlist4, linkedlist7);
        generate_section_surface(linkedlist1, linkedlist2, linkedlist7);
        Modify.remove_broken_polygons();
        double d = get_average_length(linkedlist3, linkedlist1, linkedlist4, linkedlist2);
        Tessellation.adjust_polygon_size(Modify.h, linkedlist7, d);
        Trianglation.trianglate(Modify.h);
        Tessellation.remove_thin_polygons(Modify.h);
        Modify.h.set_parameters();
        return false;
    }

    private static Objects cut_sub(LinkedList linkedlist, Enumeration enumeration, Polygon2 polygon2, Vertex2D vertex2d, Vertex vertex, boolean flag)
    {
        do
        {
            if(!enumeration.hasMoreElements())
            {
                System.out.println("Cutting sttroke is too short");
                return null;
            }
            Vertex2D vertex2d1 = (Vertex2D)enumeration.nextElement();
            Objects objects = Geometry.find_vertex_on_surface(vertex2d1, flag);
            if(objects != null)
            {
                Polygon2 polygon2_1 = (Polygon2)objects.get(0);
                Vertex vertex1 = (Vertex)objects.get(1);
                linkedlist.connect(Geometry.surface_path(vertex2d, vertex2d1, vertex, vertex1, polygon2, polygon2_1));
                linkedlist.append(objects);
                polygon2 = polygon2_1;
                vertex2d = vertex2d1;
                vertex = vertex1;
            } else
            {
                return new Objects(polygon2, vertex, vertex2d, vertex2d1);
            }
        } while(true);
    }

    private static double get_average_length_sub(LinkedList linkedlist)
    {
        double d = 0.0D;
        Enumeration enumeration = linkedlist.elements();
        Vertex vertex1;
        for(Vertex vertex = (Vertex)((Objects)enumeration.nextElement()).get(1); enumeration.hasMoreElements(); vertex = vertex1)
        {
            vertex1 = (Vertex)((Objects)enumeration.nextElement()).get(1);
            d += Vector3.distance(vertex, vertex1);
        }

        return d;
    }

    private static void generate_temp_surface_lines(Vector vector)
    {
        Modify.h.temp_surface_lines = new LinkedList();
        Enumeration enumeration = Modify.h.temp_edge_vertex_list.elements();
        enumeration.nextElement();
        Polygon2 polygon2;
        Vertex vertex;
        Vertex vertex1;
        for(; enumeration.hasMoreElements(); Modify.h.temp_surface_lines.append(new SurfaceLine(vertex.copy(), vertex1.copy(), polygon2)))
        {
            Objects objects = (Objects)enumeration.nextElement();
            Edge edge = (Edge)objects.get(0);
            polygon2 = edge.left_polygon;
            vertex = edge.start;
            vertex1 = edge.end;
            if(edge.start != objects.get(1))
            {
                polygon2 = edge.right_polygon;
                vertex = edge.end;
                vertex1 = edge.start;
            }
        }

    }

    public static boolean cut(LinkedList linkedlist, Polyhedron polyhedron, boolean flag)
    {
        Teddy.teddy.play_sound("cutting.au");
        linkedlist = Generate.normalize_Point_list(linkedlist, Def.NORMALIZED_STROKE_LENGTH_POP);
        Modify.init(polyhedron);
        LinkedList linkedlist1 = new LinkedList();
        Point point;
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); linkedlist1.append(new Vertex2D(Draw3DScene.reverse_convertX(point.x), Draw3DScene.reverse_convertY(point.y))))
            point = (Point)enumeration.nextElement();

        linkedlist1 = Generate.normalize_Vertex2D_list(linkedlist1);
        linkedlist1 = Generate.reduce_Vertex2D_list(linkedlist1, true);
        return cut_main(linkedlist1, flag);
    }

    private static Vertex find_corresponding_vertex(Vertex vertex, Vector vector)
    {
        for(int i = 0; i < vector.size(); i++)
        {
            Objects objects = (Objects)vector.elementAt(i);
            if(vertex == objects.get(0))
            {
                vertex = (Vertex)objects.get(1);
                i = 0;
            }
        }

        return vertex;
    }
}
