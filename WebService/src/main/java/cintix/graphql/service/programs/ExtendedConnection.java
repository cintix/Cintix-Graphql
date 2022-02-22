package cintix.graphql.service.programs;

import graphql.relay.Connection;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import java.util.List;

/**
 *
 * @author migo
 */
public class ExtendedConnection<T> implements Connection<T> {

    private final List<Edge<T>> edges;
    private final PageInfo pageInfo;
    private final long totalCount;

    ExtendedConnection(List<Edge<T>> edges, PageInfo pageInfo, long count) {
        this.edges = edges;
        this.pageInfo = pageInfo;
        this.totalCount = count;
    }

    @Override
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public long getTotalCount() {
        return totalCount;
    }

    @Override
    public List<Edge<T>> getEdges() {
        return edges;
    }

}
