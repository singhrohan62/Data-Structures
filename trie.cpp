#include<bits/stdc++.h>

using namespace std;

const int TOTAL_ALPHABETS = 26;

struct trieNode
{
  trieNode* children[TOTAL_ALPHABETS];
  bool isEndOfWord;
};

trieNode *getNode()
{
  trieNode* pNode = new trieNode;
  pNode->isEndOfWord = false;

  for (int i = 0; i < TOTAL_ALPHABETS; ++i)
  {
  	pNode->children[i] = NULL;
  }
  return pNode;
}

void insert(trieNode* root, string key)
{
  trieNode* pCrawl = root;

  for (int i = 0; i < key.length(); ++i)
  {
  	int index = key[i] - 'a';
  	if(!pCrawl->children[index])
  		pCrawl->children[index] = getNode();

  	pCrawl = pCrawl->children[index];
  }
  pCrawl->isEndOfWord = true;
}

bool search(trieNode* root, string key)
{
  trieNode* pCrawl = root;

  for (int i = 0; i < key.length(); ++i)
  {
  	int index = key[i] - 'a';
  	if(!pCrawl->children[index])
  		return false;
  	pCrawl = pCrawl->children[index];
  }

  return(pCrawl != NULL && pCrawl->isEndOfWord);

}

int main()
{
  string keys[] = {"the", "a", "there", 
                    "answer", "any", "by", 
                     "bye", "their" }; 
  int n = sizeof(keys)/sizeof(keys[0]); 
  trieNode* root = getNode();

  for (int i = 0; i < n; i++) 
    insert(root, keys[i]);
  search(root, "the")? cout << "Yes\n" : 
                     cout << "No\n"; 
  search(root, "these")? cout << "Yes\n" : 
                       cout << "No\n"; 
  search(root, "there")? cout << "Yes\n" : 
                       cout << "No\n";
  search(root, "their")? cout << "Yes\n" : 
                       cout << "No\n"; 
}