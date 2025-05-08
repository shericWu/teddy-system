// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SilhouetteFind.java

package teddy;


// Referenced classes of package teddy:
//            ProjectedEdge

class BoundEdges
{

    BoundEdges(ProjectedEdge projectededge)
    {
        left = projectededge;
        right = projectededge;
        top = projectededge;
        bottom = projectededge;
        left_bound = projectededge.left();
        right_bound = projectededge.right();
        top_bound = projectededge.top();
        bottom_bound = projectededge.bottom();
    }

    void check(ProjectedEdge projectededge)
    {
        if(left_bound > projectededge.left())
        {
            left_bound = projectededge.left();
            left = projectededge;
        }
        if(right_bound < projectededge.right())
        {
            right_bound = projectededge.right();
            right = projectededge;
        }
        if(top_bound > projectededge.top())
        {
            top_bound = projectededge.top();
            top = projectededge;
        }
        if(bottom_bound < projectededge.bottom())
        {
            bottom_bound = projectededge.bottom();
            bottom = projectededge;
        }
    }

    public ProjectedEdge left;
    public ProjectedEdge right;
    public ProjectedEdge top;
    public ProjectedEdge bottom;
    public double left_bound;
    public double right_bound;
    public double top_bound;
    public double bottom_bound;
}
