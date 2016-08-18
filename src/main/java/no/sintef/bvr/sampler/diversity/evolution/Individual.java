package no.sintef.bvr.sampler.diversity.evolution;

import java.util.Objects;
import no.sintef.bvr.spl.Product;
import no.sintef.bvr.spl.ProductSet;

/**
 * Individual being evolved by the genetic algorithm.
 */
public abstract class Individual implements Comparable<Individual> {

    private static final int UNKNOWN_FITNESS = 0;
    private double fitness;

    public Individual() {
        this.fitness = UNKNOWN_FITNESS;
    }

    void evaluateAgainst(Objective objective) {
        fitness = 10 * (1D / (1D + objective.distanceFrom(this)));
    }

    @Override
    public final int compareTo(Individual other) {
        return Double.compare(other.fitness, fitness);
    }

    public double fitness() {
        return this.fitness;
    }

}