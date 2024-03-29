package org.umbrella.kie.api.runtime.rule;

/**
 * This interface adds methods available to the
 * {@link org.umbrella.kie.api.runtime.KieSession} beyond what the WorkingMemory
 * provides.
 *
 * @see org.umbrella.kie.api.runtime.KieSession
 */
public interface StatefulRuleSession {

    /**
     * Fire all Matches on the Agenda.
     * 
     * @return
     *         returns the number of rules fired
     */
    int fireAllRules();

    /**
     * Fire Matches on the Agenda up to the given maximum number of Matches, before
     * returning
     * the control to the application.
     * In case the application wants to continue firing the rules later, from the
     * point where it stopped,
     * it just needs to call <code>fireAllRules()</code> again.
     *
     * @param max
     *            the maximum number of rules that should be fired
     * @return
     *         returns the number of rules fired
     */
    int fireAllRules(int max);

    /**
     * Fire all Matches on the Agenda
     *
     * @param agendaFilter
     *                     filters the Matches that may fire
     * @return
     *         returns the number of rules fired
     */
    int fireAllRules(AgendaFilter filter);

    /**
     * Fire all Matches on the Agenda
     *
     * @param agendaFilter
     *                     filters the Matches that may fire
     * @param max
     *                     the maximum number of rules that should be fired
     * @return
     *         returns the number of rules fired
     */
    int fireAllRules(AgendaFilter filter, int max);

    /**
     * Keeps firing Matches until a halt is called. If in a given moment,
     * there is no Match to fire, it will wait for an Match to be
     * added to an active agenda group or rule flow group. This blocks the thread
     * until halt is called.
     *
     * @throws IllegalStateException
     *                               if this method is called when running in
     *                               sequential mode
     */
    public void fireUntilHalt();

    /**
     * Keeps firing Matches until a halt is called. If in a given moment,
     * there is no Match to fire, it will wait for an Match to be
     * added to an active agenda group or rule flow group. This blocks the thread
     * until halt is called.
     *
     * @param agendaFilter
     *                     filters the Matches that may fire
     *
     * @throws IllegalStateException
     *                               if this method is called when running in
     *                               sequential mode
     */
    public void fireUntilHalt(AgendaFilter filter);

}
