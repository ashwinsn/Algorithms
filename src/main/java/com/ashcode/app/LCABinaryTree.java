package com.ashcode.app;

import java.util.List;

/**
 * Created by anatarajan on 3/16/16.
 */
public class LCABinaryTree {
    BinaryTree binaryTree;

    public BasicTreeNode findNodesAndLCA(BasicTreeNode node, BasicTreeNode node1,
                                         BasicTreeNode node2, List<BasicTreeNode> nodesFound){
        if(node == node1){
            nodesFound.add(node1);
        }

        if(node == node2){
            nodesFound.add(node2);
        }

        if(nodesFound.size() == 2){
            return null;
        } else {
            BasicTreeNode LCA;
            int numNodesFoundBefore = nodesFound.size();
            if(node.left != null){
               LCA = findNodesAndLCA(node.left, node1, node2, nodesFound);
               if(nodesFound.size() == 2){
                   if(numNodesFoundBefore == 0){
                       if(LCA == null){
                           return node;
                       } else {
                           return LCA;
                       }
                   }
               }
            }

            int numNodesFoundInLST = nodesFound.size() - numNodesFoundBefore;
            if(node.right != null){
                LCA = findNodesAndLCA(node.right, node1, node2, nodesFound);
                if(nodesFound.size() == 2){
                    if(numNodesFoundInLST == 1){
                        return node;
                    } else {
                        if(numNodesFoundBefore == 0){
                            if(LCA == null){
                                return node;
                            } else {
                                return LCA;
                            }
                        }
                    }
                }
            }

            return null;
        }
    }

    //first step check if both the nodes exist in the tree.
    //assuming checking by node's data and the actual node reference are the same..
    //Find LCA when link to parent exists...how?
    public BasicTreeNode LCAWhenBST(BasicTreeNode root, BasicTreeNode node1, BasicTreeNode node2,
                                    BasicTreeNode parent){
        if(root.data == node1.data){
           return parent;
        }

        if(node1.data < root.data && node2.data > root.data ||
                node1.data > root.data && node2.data < root.data){
            return root;
        }

        if(node1.data < root.data && node2.data < root.data){
            if(root.left !=null){
                return LCAWhenBST(root.left, node1, node2, root);
            }
        }

        if(node1.data > root.data && node2.data > root.data){
            if(root.right != null){
                return LCAWhenBST(root.right, node1, node2, root);
            }
        }

        return null;
    }
}
