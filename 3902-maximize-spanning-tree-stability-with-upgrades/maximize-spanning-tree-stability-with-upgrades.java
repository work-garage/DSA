// my Daily Question

class Solution {
    // Optimised Approach

    public int maxStability(int n, int[][] edges, int k) {
        // find bounds for binary search
        long maxS = 0;
        for(int[] e: edges) maxS = Math.max(maxS, e[2]);
        long lo = 0, hi = maxS * 2L; // because we can double edges
        long ans = -1;
        while(lo <= hi){
            long mid = (lo + hi) >>> 1;
            if(canAchieve(n, edges, k, mid)){
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int)ans;
    }

    class DSU {
        int[] p, r;
        int comp;
        DSU(int n){
            p = new int[n];
            r = new int[n];
            for(int i=0;i<n;i++) p[i]=i;
            comp = n;
        }
        int find(int x){
            if(p[x]==x) return x;
            return p[x] = find(p[x]);
        }
        boolean union(int a, int b){
            int pa=find(a), pb=find(b);
            if(pa==pb) return false;
            if(r[pa]<r[pb]) p[pa]=pb;
            else if(r[pb]<r[pa]) p[pb]=pa;
            else { p[pb]=pa; r[pa]++; }
            comp--;
            return true;
        }
    }

    private boolean canAchieve(int n, int[][] edges, int k, long X){
        DSU dsu = new DSU(n);

        // 1) process mandatory edges
        for(int[] e: edges){
            int u=e[0], v=e[1], s=e[2], must=e[3];
            if(must==1){
                if((long)s < X) return false; // cannot upgrade mandatory, but need >=X
                // must be included: if they create a cycle -> impossible
                if(!dsu.union(u,v)) return false; // cycle formed among mandatory edges
            }
        }

        // 2) use all optional edges with s >= X (no upgrade needed)
        for(int[] e: edges){
            int must=e[3];
            if(must==0){
                int u=e[0], v=e[1], s=e[2];
                if((long)s >= X){
                    dsu.union(u,v);
                }
            }
        }

        // 3) collect upgrade-eligible edges (s < X but 2*s >= X)
        // greedily use upgrades only when they connect components
        int upgradesUsed = 0;
        for(int[] e: edges){
            int must=e[3];
            if(must==0){
                int u=e[0], v=e[1], s=e[2];
                if((long)s < X && 2L * s >= X){
                    if(dsu.find(u) != dsu.find(v)){
                        // we would need to use one upgrade to make this edge usable
                        upgradesUsed++;
                        if(upgradesUsed > k) return false;
                        dsu.union(u,v);
                    }
                }
            }
        }

        return dsu.comp == 1;
    }
}



//Brute-force approaches (concepts + when they are usable)


// 1) Full spanning-tree enumeration (true brute force)

// Idea: enumerate every subset of edges of size n-1, check if it forms a spanning tree (connected + acyclic), for each valid tree consider every way to upgrade ≤ k eligible edges in that tree, compute tree stability (minimum edge strength after upgrades), and take the best.

// Correct but impossible for constraints: number of (n-1)-edge subsets is C(E, n-1) which is astronomically large when E up to 1e5.

// Only feasible for n ≤ ~12 or when E extremely small.





// 2) Brute force on upgrade choices + compute best tree for each

// Idea: choose a subset of optional edges to upgrade (any subset of up to k edges from M optional edges), apply upgrades, then compute the maximum bottleneck spanning tree (i.e., the spanning tree whose minimum edge is maximized). The latter can be computed by Kruskal sorting edges descending and building a maximum spanning tree; the bottleneck is the minimum edge added.

// Complexity: for each upgrade subset you run Kruskal O(E log E). Number of subsets is ∑_{i=0..k} C(M, i) — infeasible unless M and k are tiny (e.g., M ≤ 20, k ≤ 5).

// Use when M very small (toy cases) or for testing/verification.





// 3) Brute force with pruning (e.g., branch & bound)

// Idea: DFS choosing edges to include into tree while pruning when you get cycles or when lower bound on achievable bottleneck becomes worse than current best. Hard to design strong pruning for this problem. Still exponential in worst case.