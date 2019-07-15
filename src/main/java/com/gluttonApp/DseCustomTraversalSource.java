package com.gluttonApp;

import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

public class DseCustomTraversalSource extends GraphTraversalSource{
    public DseCustomTraversalSource(Graph graph) {
        super(graph);
    }

    public DseCustomTraversalSource(Graph graph, TraversalStrategies strategies) {
        super(graph, strategies);
    }
}
