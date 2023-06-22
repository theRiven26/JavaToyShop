package ui;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start() throws Exception;
    void setPresenter(Presenter presenter);
}
