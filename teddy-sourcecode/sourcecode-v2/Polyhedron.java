// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Polyhedron.java

package teddy;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package teddy:
//            Polygon2, Edge, Vector3, Vertex, 
//            LinkedList, SurfaceLine, Trianglation, Objects

class Polyhedron
    implements Serializable
{
    class TmpPolygon
    {

        public Polygon2 get_polygon()
        {
            if(n_vertices == 3)
            {
                Edge edge = get_edge(vertices[0], vertices[1]);
                Edge edge2 = get_edge(vertices[1], vertices[2]);
                Edge edge4 = get_edge(vertices[2], vertices[0]);
                return new Polygon2(edge, edge2, edge4);
            }
            if(n_vertices == 4)
            {
                Edge edge1 = get_edge(vertices[0], vertices[1]);
                Edge edge3 = get_edge(vertices[1], vertices[2]);
                Edge edge5 = get_edge(vertices[2], vertices[3]);
                Edge edge6 = get_edge(vertices[3], vertices[0]);
                return new Polygon2(edge1, edge3, edge5, edge6);
            }
            LinkedList linkedlist = new LinkedList();
            int i;
            for(i = 0; i < n_vertices - 1; i++)
                linkedlist.append(get_edge(vertices[i], vertices[i + 1]));

            linkedlist.append(get_edge(vertices[i], vertices[0]));
            return new Polygon2(linkedlist);
        }

        public int n_vertices;
        public Vertex vertices[];

        TmpPolygon(Vertex vertex, Vertex vertex1, Vertex vertex2, Vertex vertex3)
        {
            n_vertices = 4;
            vertices = new Vertex[n_vertices];
            vertices[0] = vertex;
            vertices[1] = vertex1;
            vertices[2] = vertex2;
            vertices[3] = vertex3;
        }

        TmpPolygon(Vertex vertex, Vertex vertex1, Vertex vertex2)
        {
            n_vertices = 3;
            vertices = new Vertex[n_vertices];
            vertices[0] = vertex;
            vertices[1] = vertex1;
            vertices[2] = vertex2;
        }

        TmpPolygon(LinkedList linkedlist)
        {
            n_vertices = linkedlist.size();
            vertices = new Vertex[n_vertices];
            Enumeration enumeration = linkedlist.elements();
            int i = 0;
            while(enumeration.hasMoreElements()) 
                vertices[i++] = (Vertex)enumeration.nextElement();
        }
    }


    public void set_parameters()
    {
        for(int i = 0; i < n_polygons; i++)
        {
            polygons[i].set_normal();
            polygons[i].polyhedron = this;
        }

        for(int j = 0; j < n_edges; j++)
            edges[j].set_parameters();

        base_x = new Vector3(1.0D, 0.0D, 0.0D);
        base_y = new Vector3(0.0D, 1.0D, 0.0D);
        base_z = new Vector3(0.0D, 0.0D, 1.0D);
        view_changed = true;
    }

    public void restore(Polyhedron polyhedron)
    {
        n_vertices = polyhedron.n_vertices;
        n_edges = polyhedron.n_edges;
        n_polygons = polyhedron.n_polygons;
        max_n_vertices = polyhedron.max_n_vertices;
        max_n_edges = polyhedron.max_n_edges;
        max_n_polygons = polyhedron.max_n_polygons;
        vertices = polyhedron.vertices;
        edges = polyhedron.edges;
        polygons = polyhedron.polygons;
        for(int i = 0; i < n_polygons; i++)
            polygons[i].polyhedron = this;

        surface_lines = polyhedron.surface_lines;
        temp_surface_lines = polyhedron.temp_surface_lines;
        temp_edge_vertex_list = polyhedron.temp_edge_vertex_list;
        base_x = polyhedron.base_x;
        base_y = polyhedron.base_y;
        base_z = polyhedron.base_z;
        current_part_index = polyhedron.current_part_index;
        max_part_index = polyhedron.max_part_index;
        parent_of_a_part = (int[])polyhedron.parent_of_a_part.clone();
        pivot_of_a_part = (Vertex[])polyhedron.pivot_of_a_part.clone();
        normal_of_a_part = (Vector3[])polyhedron.normal_of_a_part.clone();
    }

    protected void postprocess()
    {
        postprocess_main();
        size_normalize();
        set_parameters();
    }

    void rotate_x(double d)
    {
        rotate_sub(0, d);
    }

    public void replace_edge(Edge edge, Edge edge1, Edge edge2)
    {
        if(edge.right_polygon() != null)
            edge.right_polygon().edge_replace(edge, edge1, edge2);
        if(edge.left_polygon() != null)
            edge.left_polygon().edge_replace(edge, edge1, edge2);
        remove(edge);
    }

    void rotate_y(double d)
    {
        rotate_sub(1, d);
    }

    public void replace_edge(Edge edge, Edge edge1, Edge edge2, Edge edge3)
    {
        if(edge.right_polygon() != null)
            edge.right_polygon().edge_replace(edge, edge1, edge2, edge3);
        if(edge.left_polygon() != null)
            edge.left_polygon().edge_replace(edge, edge1, edge2, edge3);
        remove(edge);
    }

    protected Edge get_edge(Vertex vertex, Vertex vertex1)
    {
        for(Enumeration enumeration = vertex.edges.elements(); enumeration.hasMoreElements();)
        {
            Edge edge = (Edge)enumeration.nextElement();
            if(edge.same_edge(vertex, vertex1))
                return edge;
        }

        for(Enumeration enumeration1 = vertex1.edges.elements(); enumeration1.hasMoreElements();)
        {
            Edge edge1 = (Edge)enumeration1.nextElement();
            if(edge1.same_edge(vertex, vertex1))
                return edge1;
        }

        Edge edge2 = new Edge(vertex, vertex1);
        _edges.append(edge2);
        return edge2;
    }

    public Vertex get_vertex(Edge edge, Edge edge1)
    {
        if(edge.start() == edge1.start() || edge.start() == edge1.end())
            return edge.start();
        else
            return edge.end();
    }

    protected Vertex get_vertex(double d, double d1, double d2)
    {
        for(Enumeration enumeration = _vertices.elements(); enumeration.hasMoreElements();)
        {
            Vertex vertex = (Vertex)enumeration.nextElement();
            if(vertex.same_vertex(d, d1, d2))
                return vertex;
        }

        Vertex vertex1 = new Vertex(d, d1, d2);
        _vertices.append(vertex1);
        return vertex1;
    }

    public void append_edges(LinkedList linkedlist)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); append((Edge)enumeration.nextElement()));
    }

    public void append_a_new_polygon(Vertex vertex, Vertex vertex1, Vertex vertex2)
    {
        Edge edge = get_edge_array(vertex, vertex1);
        Edge edge1 = get_edge_array(vertex1, vertex2);
        Edge edge2 = get_edge_array(vertex2, vertex);
        append(new Polygon2(edge, edge1, edge2));
    }

    protected void postprocess_no_normalize()
    {
        postprocess_main();
        set_parameters();
    }

    protected Vertex get_vertex(Vertex vertex)
    {
        return get_vertex(((Vector3) (vertex)).x, ((Vector3) (vertex)).y, ((Vector3) (vertex)).z);
    }

    void rotate_z(double d)
    {
        rotate_sub(2, d);
    }

    public void append_vertices(LinkedList linkedlist)
    {
        for(Enumeration enumeration = linkedlist.elements(); enumeration.hasMoreElements(); append((Vertex)enumeration.nextElement()));
    }

    public void remove(Vertex vertex)
    {
        int i;
        for(i = 0; i < n_vertices; i++)
            if(vertices[i] == vertex)
                break;

        if(i == n_vertices)
            return;
        for(; i < n_vertices - 1; i++)
            vertices[i] = vertices[i + 1];

        n_vertices--;
    }

    public void remove(Polygon2 polygon2)
    {
        int i;
        for(i = 0; i < n_polygons; i++)
            if(polygons[i] == polygon2)
                break;

        if(i == n_polygons)
            return;
        for(; i < n_polygons - 1; i++)
            polygons[i] = polygons[i + 1];

        n_polygons--;
        for(int j = 0; j < polygon2.n_edges; j++)
        {
            polygon2.edges(j).remove_polygon(polygon2);
            if(polygon2.edges(j).polygon_is_empty())
                remove(polygon2.edges(j));
        }

        for(Enumeration enumeration = polygon2.surface_lines.elements(); enumeration.hasMoreElements(); surface_lines.remove((SurfaceLine)enumeration.nextElement()));
    }

    public void remove(Edge edge)
    {
        int i;
        for(i = 0; i < n_edges; i++)
            if(edges[i] == edge)
                break;

        if(i == n_edges)
        {
            System.out.println("try to remove invalid (Polyhedron.remove(Edge))");
            return;
        }
        for(; i < n_edges - 1; i++)
            edges[i] = edges[i + 1];

        n_edges--;
        edge.start.remove_edge(edge);
        if(edge.start.edge_is_empty())
            remove(edge.start);
        edge.end.remove_edge(edge);
        if(edge.end.edge_is_empty())
            remove(edge.end);
    }

    Polyhedron()
    {
        section_bumping = false;
        parent_of_a_part = new int[20];
        pivot_of_a_part = new Vertex[20];
        normal_of_a_part = new Vector3[20];
        current_part_index = 0;
        max_part_index = 0;
        base_x = new Vector3(1.0D, 0.0D, 0.0D);
        base_y = new Vector3(0.0D, 1.0D, 0.0D);
        base_z = new Vector3(0.0D, 0.0D, 1.0D);
        surface_lines = new LinkedList();
        temp_surface_lines = new LinkedList();
        temp_edge_vertex_list = new LinkedList();
        view_changed = true;
        parent_of_a_part[0] = -1;
        pivot_of_a_part[0] = new Vertex(0.0D, 0.0D, 0.0D);
        normal_of_a_part[0] = new Vector3(1.0D, 0.0D, 0.0D);
    }

    protected void postprocess_main()
    {
        TmpPolygon tmppolygon;
        for(Enumeration enumeration = tmp_polygons.elements(); enumeration.hasMoreElements(); _polygons.append(tmppolygon.get_polygon()))
            tmppolygon = (TmpPolygon)enumeration.nextElement();

        n_vertices = _vertices.size();
        n_edges = _edges.size();
        n_polygons = _polygons.size();
        max_n_vertices = n_vertices * 2;
        max_n_edges = n_edges * 2;
        max_n_polygons = n_polygons * 2;
        vertices = new Vertex[max_n_vertices];
        edges = new Edge[max_n_edges];
        polygons = new Polygon2[max_n_polygons];
        int i = 0;
        for(Enumeration enumeration1 = _vertices.elements(); enumeration1.hasMoreElements();)
            vertices[i++] = (Vertex)enumeration1.nextElement();

        i = 0;
        for(Enumeration enumeration2 = _edges.elements(); enumeration2.hasMoreElements();)
            edges[i++] = (Edge)enumeration2.nextElement();

        i = 0;
        for(Enumeration enumeration3 = _polygons.elements(); enumeration3.hasMoreElements();)
        {
            Polygon2 polygon2 = (Polygon2)enumeration3.nextElement();
            polygon2.polyhedron = this;
            polygons[i++] = polygon2;
        }

        Trianglation.trianglate(this);
    }

    public Polyhedron(Vector vector, Vector vector1, Vector vector2, Vector vector3)
    {
        this();
        tmp_polygons = new LinkedList();
        _vertices = new LinkedList();
        _edges = new LinkedList();
        _polygons = new LinkedList();
        for(int i = 0; i < vector.size(); i++)
            _vertices.append(vector.elementAt(i));

        for(int j = 0; j < vector1.size(); j++)
        {
            Vector vector4 = (Vector)vector1.elementAt(j);
            LinkedList linkedlist = new LinkedList();
            for(int i1 = 0; i1 < vector4.size(); i1++)
                linkedlist.append(vector.elementAt(((Integer)vector4.elementAt(i1)).intValue()));

            tmp_polygons.append(new TmpPolygon(linkedlist));
        }

        postprocess_no_normalize();
        for(int k = 0; k < vector2.size(); k++)
        {
            Objects objects = (Objects)vector2.elementAt(k);
            Vertex vertex = vertices[((Integer)objects.get(0)).intValue()];
            Vertex vertex2 = vertices[((Integer)objects.get(1)).intValue()];
            Edge edge = vertex.get_shared_edge(vertex2);
            edge.set_sharp(true);
        }

        for(int l = 0; l < vector3.size(); l++)
        {
            Objects objects1 = (Objects)vector3.elementAt(l);
            Vertex vertex1 = (Vertex)objects1.get(0);
            Vertex vertex3 = (Vertex)objects1.get(1);
            Polygon2 polygon2 = polygons[((Integer)objects1.get(2)).intValue()];
            surface_lines.append(new SurfaceLine(vertex1, vertex3, polygon2));
        }

    }

    public boolean contains(Polygon2 polygon2)
    {
        for(int i = 0; i < n_polygons; i++)
            if(polygons[i] == polygon2)
                return true;

        return false;
    }

    public void size_normalize()
    {
        double d = 0.0D;
        for(int i = 0; i < n_vertices; i++)
            d = Math.max(d, Math.sqrt(((Vector3) (vertices[i])).x * ((Vector3) (vertices[i])).x + ((Vector3) (vertices[i])).y * ((Vector3) (vertices[i])).y + ((Vector3) (vertices[i])).z * ((Vector3) (vertices[i])).z));

        for(int j = 0; j < n_vertices; j++)
        {
            vertices[j].x = ((Vector3) (vertices[j])).x / d;
            vertices[j].y = ((Vector3) (vertices[j])).y / d;
            vertices[j].z = ((Vector3) (vertices[j])).z / d;
        }

    }

    public Vertex absolute_coords(Vector3 vector3)
    {
        double d = base_x.x * vector3.x + base_y.x * vector3.y + base_z.x * vector3.z;
        double d1 = base_x.y * vector3.x + base_y.y * vector3.y + base_z.y * vector3.z;
        double d2 = base_x.z * vector3.x + base_y.z * vector3.y + base_z.z * vector3.z;
        return new Vertex(d, d1, d2);
    }

    public void after_loaded()
    {
        temp_surface_lines = new LinkedList();
        temp_edge_vertex_list = new LinkedList();
    }

    public Polyhedron copy()
    {
        Polyhedron polyhedron = new Polyhedron();
        polyhedron.n_vertices = n_vertices;
        polyhedron.n_edges = n_edges;
        polyhedron.n_polygons = n_polygons;
        polyhedron.max_n_vertices = max_n_vertices;
        polyhedron.max_n_edges = max_n_edges;
        polyhedron.max_n_polygons = max_n_polygons;
        polyhedron.base_x = base_x.copyVector3();
        polyhedron.base_y = base_y.copyVector3();
        polyhedron.base_z = base_z.copyVector3();
        polyhedron.view_changed = true;
        polyhedron.vertices = new Vertex[max_n_vertices];
        for(int i = 0; i < n_vertices; i++)
            polyhedron.vertices[i] = vertices[i].copy();

        polyhedron.edges = new Edge[max_n_edges];
        for(int j = 0; j < n_edges; j++)
            polyhedron.edges[j] = edges[j].copy();

        polyhedron.polygons = new Polygon2[max_n_polygons];
        for(int k = 0; k < n_polygons; k++)
            polyhedron.polygons[k] = polygons[k].copy();

        for(int l = 0; l < n_vertices; l++)
            polyhedron.vertices[l].renew_network();

        for(int i1 = 0; i1 < n_edges; i1++)
            polyhedron.edges[i1].renew_network();

        for(int j1 = 0; j1 < n_polygons; j1++)
            polyhedron.polygons[j1].renew_network();

        polyhedron.surface_lines = new LinkedList();
        for(Enumeration enumeration = surface_lines.elements(); enumeration.hasMoreElements(); polyhedron.surface_lines.append(((SurfaceLine)enumeration.nextElement()).copy()));
        polyhedron.temp_surface_lines = new LinkedList();
        for(Enumeration enumeration1 = temp_surface_lines.elements(); enumeration1.hasMoreElements(); polyhedron.temp_surface_lines.append(((SurfaceLine)enumeration1.nextElement()).copy()));
        polyhedron.temp_edge_vertex_list = new LinkedList();
        for(Enumeration enumeration2 = temp_edge_vertex_list.elements(); enumeration2.hasMoreElements();)
        {
            Objects objects = (Objects)enumeration2.nextElement();
            Vertex vertex = ((Vertex)objects.get(1)).child;
            if(objects.get(0) instanceof Edge)
            {
                Edge edge = ((Edge)objects.get(0)).child;
                polyhedron.temp_edge_vertex_list.append(new Objects(edge, vertex));
            } else
            {
                Polygon2 polygon2 = ((Polygon2)objects.get(0)).child;
                polyhedron.temp_edge_vertex_list.append(new Objects(polygon2, vertex));
            }
        }

        polyhedron.current_part_index = current_part_index;
        polyhedron.max_part_index = max_part_index;
        polyhedron.parent_of_a_part = (int[])parent_of_a_part.clone();
        polyhedron.pivot_of_a_part = (Vertex[])pivot_of_a_part.clone();
        polyhedron.normal_of_a_part = (Vector3[])normal_of_a_part.clone();
        return polyhedron;
    }

    public Edge get_edge_array(Vertex vertex, Vertex vertex1)
    {
        for(int i = 0; i < n_edges; i++)
            if(edges[i].same_edge(vertex, vertex1))
                return edges[i];

        Edge edge = new Edge(vertex, vertex1);
        append(edge);
        return edge;
    }

    public void set_sharp_edges()
    {
        for(int i = 0; i < n_edges; i++)
            edges[i].set_sharp_if_sharp();

    }

    public Vertex relative_coords(Vector3 vector3)
    {
        double d = base_x.dot_product(vector3);
        double d1 = base_y.dot_product(vector3);
        double d2 = base_z.dot_product(vector3);
        return new Vertex(d, d1, d2);
    }

    public void append(Polygon2 polygon2)
    {
        n_polygons++;
        if(n_polygons > max_n_polygons)
        {
            max_n_polygons *= 2;
            Polygon2 apolygon2[] = polygons;
            polygons = new Polygon2[max_n_polygons];
            for(int i = 0; i < n_polygons - 1; i++)
                polygons[i] = apolygon2[i];

        }
        polygon2.polyhedron = this;
        polygons[n_polygons - 1] = polygon2;
        polygon2.part_index = current_part_index;
    }

    void rotate_sub(int i, double d)
    {
        base_x.rotate(i, d);
        base_y.rotate(i, d);
        base_z.rotate(i, d);
        for(int j = 0; j < n_vertices; j++)
            vertices[j].rotate(i, d);

        Edge edge;
        for(Enumeration enumeration = surface_lines.elements(); enumeration.hasMoreElements(); edge.end.rotate(i, d))
        {
            edge = (Edge)enumeration.nextElement();
            edge.start.rotate(i, d);
        }

        Edge edge1;
        for(Enumeration enumeration1 = temp_surface_lines.elements(); enumeration1.hasMoreElements(); edge1.end.rotate(i, d))
        {
            edge1 = (Edge)enumeration1.nextElement();
            edge1.start.rotate(i, d);
        }

        for(int k = 0; k <= max_part_index; k++)
        {
            pivot_of_a_part[k].rotate(i, d);
            normal_of_a_part[k].rotate(i, d);
        }

        view_changed = true;
    }

    public void append(Vertex vertex)
    {
        n_vertices++;
        if(n_vertices > max_n_vertices)
        {
            max_n_vertices *= 2;
            Vertex avertex[] = vertices;
            vertices = new Vertex[max_n_vertices];
            for(int i = 0; i < n_vertices - 1; i++)
                vertices[i] = avertex[i];

        }
        vertices[n_vertices - 1] = vertex;
    }

    public void append(Edge edge)
    {
        n_edges++;
        if(n_edges > max_n_edges)
        {
            max_n_edges *= 2;
            Edge aedge[] = edges;
            edges = new Edge[max_n_edges];
            for(int i = 0; i < n_edges - 1; i++)
                edges[i] = aedge[i];

        }
        edges[n_edges - 1] = edge;
    }

    public Vertex vertices[];
    public Edge edges[];
    public Polygon2 polygons[];
    public int n_vertices;
    public int n_edges;
    public int n_polygons;
    public int max_n_vertices;
    public int max_n_edges;
    public int max_n_polygons;
    public LinkedList surface_lines;
    public transient LinkedList temp_surface_lines;
    public transient LinkedList temp_edge_vertex_list;
    public Vector3 base_x;
    public Vector3 base_y;
    public Vector3 base_z;
    public boolean view_changed;
    public transient boolean section_bumping;
    public int parent_of_a_part[];
    public Vertex pivot_of_a_part[];
    public Vector3 normal_of_a_part[];
    public int current_part_index;
    public int max_part_index;
    protected transient LinkedList tmp_polygons;
    protected transient LinkedList _vertices;
    protected transient LinkedList _edges;
    protected transient LinkedList _polygons;
}
