package com.loh.tally.ui.modules.list.adapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.loh.tally.R;
import com.loh.tally.domain.model.Module;
import com.loh.tally.ui.base.EmptyListStateListener;
import com.loh.tally.ui.base.dagger.scope.ViewScope;

import javax.inject.Inject;

/**
 * File: ModuleListAdapter.java
 * Date: 10/03/2017
 * Created By: Liam O'Hanlon
 */
@ViewScope
public class ModuleListAdapter extends FirebaseRecyclerAdapter<Module, ModuleViewHolder> {

    private ModuleViewHolder.OnModuleItemClickListener listener;
    private EmptyListStateListener emptyListStateListener;

    @Inject
    public ModuleListAdapter(Query ref) {
        this(Module.class, R.layout.item_module_list, ModuleViewHolder.class, ref);
    }

    /**
     * @param modelClass      Firebase will marshall the data at a location into an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list. You will be responsible for populating an
     *                        instance of the corresponding view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location, using some
     *                        combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */
    private ModuleListAdapter(Class<Module> modelClass, int modelLayout, Class<ModuleViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(ModuleViewHolder viewHolder, Module model, int position) {
        viewHolder.bind(model, listener);
    }

    @Override
    protected void onDataChanged() {
        super.onDataChanged();
        emptyListStateListener.onEmpty();
    }

    public void setOnItemClickListener(ModuleViewHolder.OnModuleItemClickListener listener) {
        this.listener = listener;
    }

    public void setEmptyListStateListener(EmptyListStateListener emptyListStateListener) {
        this.emptyListStateListener = emptyListStateListener;
    }
}
