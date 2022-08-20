package com.apitirage.FreeTirage.Services;

import java.util.List;
import java.util.Random;

public interface ServiceTirage {
  Random trie(Random ro);
  List<Integer> idPostulant();
}
